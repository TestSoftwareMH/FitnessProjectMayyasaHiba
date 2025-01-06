package fit.man.sys.project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Offer;
import org.example.mainProgram;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class announcementTest {

    mainProgram pro;
    private String result;
    Offer off;

    @Given("User has logged in as instructor to announce")
    public void user_has_logged_in_as_instructor_to_announce() {
        mainProgram.login("Instructor");
        assertTrue("The user is not instructor",mainProgram.login("Instructor"));
    }


    @When("User create new program with the following details and want clients to know that:")
    public void userCreateNewProgramWithTheFollowingDetailsAndWantClientsToKnowThat(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> programDetailsList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> programDetails : programDetailsList) {
            try {
                if (programDetails.get("Program ID") == null || programDetails.get("Duration") == null || programDetails.get("Price") == null) {
                    result = "Fail";
                    return;
                } else {
                    pro = new mainProgram(
                            Integer.parseInt(programDetails.get("Program ID")),
                            programDetails.get("Program title"),
                            Integer.parseInt(programDetails.get("Duration")),
                            programDetails.get("Difficulty level"),
                            programDetails.get("Goals"),
                            programDetails.get("Description"),
                            Double.parseDouble(programDetails.get("Price")),
                            programDetails.get("Schedule type"),
                            programDetails.get("Schedule time")
                    );
                    result = mainProgram.createResult(pro);
                }

            } catch (Exception e) {
                result = "Fail";
            }
        }
    }

    @When("User announce about special offer {int} with following details:")
    public void user_announce_about_special_offer_with_following_details(Integer OId,io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> programDetailsList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> programDetails : programDetailsList) {
            try {
                OId = Integer.parseInt(programDetails.get("Offer ID"));
                off = new Offer(programDetails.get("Offer title"),programDetails.get("Description"),programDetails.get("First date of the offer"),programDetails.get("Last date of the offer"),Double.parseDouble(programDetails.get("price")));
                off.setId(OId);
                result=mainProgram.announceResult(programDetails.get("First date of the offer"),programDetails.get("Last date of the offer"));
            }catch (Exception e) {
                result = "Fail";}
        }
    }

    @Then("The announce should be delivered")
    public void the_announce_should_be_delivered() {
        mainProgram.announceNewPro(pro);
        assertEquals("Fail to announce","Success",result);
    }
    @Then("The announce of offer should be delivered")
    public void the_announce_of_offer_should_be_delivered() {
        mainProgram.announceOffer(off);
        assertEquals("Fail to announce","Success",result);
    }

    @When("User announce about special offer {int} with invalid period with following details:")
    public void user_announce_about_special_offer_with_invalid_period_with_following_details(Integer OId,io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> programDetailsList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> programDetails : programDetailsList) {
            try {
                OId = Integer.parseInt(programDetails.get("Offer ID"));
                off = new Offer(programDetails.get("Offer title"),programDetails.get("Description"),programDetails.get("First date of the offer"),programDetails.get("Last date of the offer"),Double.parseDouble(programDetails.get("price")));
                off.setId(OId);
                result=mainProgram.announceResult(programDetails.get("First date of the offer"),programDetails.get("Last date of the offer"));
            }catch (Exception e) {
                result = "Fail";}
        }
    }


    @Then("The announce should not be delivered")
    public void the_announce_should_not_be_delivered() {
        assertEquals("Success to send announce","Fail",result);
    }

}

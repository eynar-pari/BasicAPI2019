package gradle.cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import factoryRequest.CustomReponse;
import factoryRequest.FactoryRequest;
import helpers.JsonUtil;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class MyStepdefs {

    public static CustomReponse globalResponse;
    public Map<String,String> globalVar=new HashMap<>();


    @And("^I get the attribute (.*) and save on (.*)$")
    public void iGetTheAttributeNAME_ATTRIBUTEAndSaveOnNAME_VAR(String attribute,String nameVar) throws Throwable {
       String valueAttribute= JsonUtil.getJsonValue(globalResponse.getJsonBody(),attribute);
       System.out.println("\nINFO>\t glovalVar : ["+nameVar+"] has value : ["+valueAttribute+"]");
       globalVar.put(nameVar,valueAttribute);
    }

    @Given("^I have a connection with Todo.Ly$")
    public void iHaveAConnectionWithTodoLy() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("^I send a (POST|PUT|DELETE|GET) request to (projects.json) end point with the json$")
    public void iSendAPOSTRequestToProjectsJsonEndPointWithTheJson(String method, String path, String body) throws Throwable {
        globalResponse=FactoryRequest.make(method.toLowerCase())
                .send(buildString(path),buildString(body));
    }

    @Then("^the response code should be (\\d+)$")
    public void theResponseCodeShouldBe(int expected) throws Throwable {
        Assert.assertEquals("The expected is not equal to the actual",expected,globalResponse.getCodeStatus());
    }

    @And("^I expected the json response body contains (.*)$")
    public void iExpectedTheJsonResponseBodyContainsNAME(String nameProject) throws Throwable {
          Assert.assertTrue("El Project no fue creado",
                  globalResponse.getJsonBody().contains(nameProject) );
    }

    @And("^I expected the json response body equal to$")
    public void iExpectedTheJsonResponseBodyEqualTo(String expectedJsom) throws Throwable {
          String actualJson= globalResponse.getJsonBody();
          Assert.assertTrue("ERROR !!! al comparar",
                  JsonUtil.areEqualsJsonObject(this.buildString(expectedJsom),actualJson));
    }

     private String buildString(String value){
        for (String key: globalVar.keySet())
           value=value.replace(key,globalVar.get(key));
        return value;
    }




}

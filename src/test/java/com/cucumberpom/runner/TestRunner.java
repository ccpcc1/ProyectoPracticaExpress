package com.cucumberpom.runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/cucumber/features/ShoopingCar.feature"//mirar que caso voy a desarrollar
        ,glue={"com/cucumber/stepDefinitions"}
        ,plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json"
        ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"} //para generar reporte en la carpeta target y otros archivos
        ,monochrome = true)
public class TestRunner {
    //mvn test -DexecMode=normal
}

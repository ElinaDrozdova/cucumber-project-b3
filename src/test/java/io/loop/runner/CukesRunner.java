//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package io.loop.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"}, //it's where file is stored
        glue = {"io/loop/step_definitions"}, //it's where step definitions code stored
        dryRun = false, //when its false it actually runs the test, when its true - generating code snippet
        tags = "@smoke",
        monochrome = true
)
public class CukesRunner {
    public CukesRunner() {
    }
}

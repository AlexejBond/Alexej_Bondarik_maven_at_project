package practice.recipes;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class RecipeRunnerYaml {
    public static void main(String[] args) throws IOException {
        RecipeRunnerYaml recipeYamlRunner = new RecipeRunnerYaml();
        recipeYamlRunner.toYaml();
        recipeYamlRunner.fromYaml();
    }

    public void toYaml() throws IOException {
        Recipe recipe = new Recipe("Salad",
                Arrays.asList(
                        new Ingredient("Tomato", 2),
                        new Ingredient("Cucumber", 1)),
                3);
        YAMLMapper xmlMapper = new YAMLMapper();
        xmlMapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("src/test/resources/recipes/recipe.yaml"), recipe);
        String xml = xmlMapper.writeValueAsString(recipe);
    }

    public void fromYaml() throws IOException {
        YAMLMapper xmlMapper = new YAMLMapper();
        Recipe recipe = xmlMapper
                .readValue(new File("src/test/resources/recipes/recipe.yaml"), Recipe.class);
        System.out.println(recipe);
    }
}

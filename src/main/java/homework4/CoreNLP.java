/*
 *
 *  * (c) 2015 - 2020 ENisco GmbH & Co. KG
 *
 */

package homework4;

import edu.stanford.nlp.simple.Sentence;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import lombok.SneakyThrows;
import opennlp.tools.lemmatizer.DictionaryLemmatizer;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.SimpleTokenizer;
import org.apache.commons.io.FileUtils;

public class CoreNLP
{

    @SneakyThrows
    public static void main(String... args)
    {

        //var text = "src/main/resources/texts/doyle.txt";
        //var text = "src/main/resources/texts/twain.txt";
        var text = "src/main/resources/texts/wilde.txt";
        var data = FileUtils.readFileToString(new File(text), StandardCharsets.UTF_8);


        var coreNlp = coreNLP(data);
        var corenlpset = new HashSet<>(coreNlp);
        System.out.println("-------core nlp---------");
        System.out.println("Size: " + corenlpset.size() + " / " + coreNlp.size());

        var openNlp = openNLP(data);
        var opennlpset = new HashSet<>(openNlp);


        System.out.println("-------open nlp---------");
        System.out.println("Size: " + opennlpset.size() + " / " + openNlp.size());


    }



    @SneakyThrows
    private static List<String> coreNLP(String data){
        var props = new Properties();
        props.put("annotators", "tokenize, ssplit, pos, lemma");

        var sent = new Sentence(data, props);

        return sent.lemmas(props);

    }

    @SneakyThrows
    private static List<String> openNLP(String data){

        var tokenizer = SimpleTokenizer.INSTANCE;
        var tokens = tokenizer.tokenize(data);

        var posModel = new POSModel(new File("src/main/resources/models/en-pos-maxent.bin"));
        var posTagger = new POSTaggerME(posModel);
        var tags = posTagger.tag(tokens);
        var lemmatizer = new DictionaryLemmatizer(
                new File("src/main/resources/models/en-lemmatizer.dict"));
        var lemmas = lemmatizer.lemmatize(tokens, tags);

        return Arrays.asList(lemmas);
    }

}

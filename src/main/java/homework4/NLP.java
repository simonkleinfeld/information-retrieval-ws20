/*
 *
 *  * (c) 2015 - 2020 ENisco GmbH & Co. KG
 *
 */

package homework4;

import edu.stanford.nlp.simple.Sentence;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import lombok.SneakyThrows;
import opennlp.tools.lemmatizer.DictionaryLemmatizer;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.SimpleTokenizer;
import org.apache.commons.io.FileUtils;

public class NLP
{

    @SneakyThrows
    public static void main(String... args)
    {
        if(args.length == 0){
            throw new IllegalArgumentException("Pass the textfile you want to lemmatize as a parameter");
        }
        var text = args[0];
        var data = FileUtils.readFileToString(new File(text), StandardCharsets.UTF_8);

        var coreNlp = new ArrayList<>(coreNLP(data));
        var corenlpset = new HashSet<>(coreNlp);
        System.out.println("-------core nlp---------");
        System.out.println("Without duplicates: " + corenlpset.size() + " /with duplicates " + coreNlp.size());

        var openNlp = openNLP(data);
        var opennlpset = new HashSet<>(openNlp);

        System.out.println("-------open nlp---------");
        System.out.println("Without duplicates: " + opennlpset.size() + " /with duplicates " + openNlp.size());

        var copy1 = new ArrayList<>(corenlpset);
        var copy2 = new ArrayList<>(opennlpset);
        var copy3 = new ArrayList<>(corenlpset);
        var copy4 = new ArrayList<>(opennlpset);
        System.out.println("Elements that are in coreNLP but not in openNLP");
        copy1.removeAll(copy2);
        Collections.sort(copy1);
        System.out.println(copy1);
        System.out.println("Elements that are in openNlp but not in coreNLP");
        copy4.removeAll(copy3);
        Collections.sort(copy4);
        System.out.println(copy4);

    }

    @SneakyThrows
    private static List<String> coreNLP(String data)
    {
        var props = new Properties();
        props.put("annotators", "tokenize, ssplit, pos, lemma");

        var sent = new Sentence(data, props);

        return sent.lemmas(props);

    }

    @SneakyThrows
    private static List<String> openNLP(String data)
    {

        var tokenizer = SimpleTokenizer.INSTANCE;
        var tokens = tokenizer.tokenize(data);

        var posModel = new POSModel(new File("src/main/resources/models/en-pos-maxent.bin"));
        var posTagger = new POSTaggerME(posModel);
        var tags = posTagger.tag(tokens);
        var lemmatizer = new DictionaryLemmatizer(new File("src/main/resources/models/en-lemmatizer.dict"));
        var lemmas = lemmatizer.lemmatize(tokens, tags);

        return Arrays.asList(lemmas);
    }

}

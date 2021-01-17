package com.yuliana.composition.service.impl;

import com.yuliana.composition.entity.CurrentLevel;
import com.yuliana.composition.entity.TextComponent;
import com.yuliana.composition.entity.TextComposite;
import com.yuliana.composition.service.TextService;

import java.util.*;

public class TextServiceImpl implements TextService {

    @Override
    public TextComposite sortParagraphBySentenceCount(TextComposite text) {
        HashMap<Integer,TextComponent> paragraphs = new HashMap<>();
        HashMap<Integer,TextComponent> sortedParagraphs = new HashMap<>();
        TextComposite sortedText = new TextComposite();
        sortedText.setCurrentLevel(CurrentLevel.TEXT);
        for(TextComponent component : text.getComponents()){
            int sentencesCount = countSentences((TextComposite)component);
            paragraphs.put(sentencesCount, component);
        }
        paragraphs.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEachOrdered(x -> sortedParagraphs.put(x.getKey(), x.getValue()));
        for(TextComponent component : sortedParagraphs.values()){
            text.add(component);
        }
        return null;
    }

    @Override
    public TextComposite searchLongestWordSentences(TextComposite text) {
        HashMap<Integer,TextComponent> sentences = new HashMap<>();
        for(TextComponent paragraph : text.getComponents()){
            for(TextComponent sentence : text.getComponents()){
                int longestWordInSentence = longestWordLettersCount((TextComposite)sentence);
                sentences.put(longestWordInSentence, sentence);
            }
        }
        int longestWord = Collections.max(sentences.keySet());
        TextComposite result = (TextComposite)sentences.get(longestWord);
        return result;
    }

    @Override
    public void deleteSentencesLessWordsCount(TextComposite text, int wordsCount) {
        for(TextComponent paragraph : text.getComponents()){
            for (TextComponent sentence : paragraph.getComponents()){
                int words = countWords(sentence);
                if(words < wordsCount){
                    paragraph.remove(sentence);
                }
            }
        }
    }

    @Override
    public int searchSameWordsRegisterIndependent(TextComposite composite) {
        return 0;
    }

    private int countSentences(TextComposite paragraph){
       int count = 0;
        for (TextComponent sentence : paragraph.getComponents()){
            if(sentence.getCurrentLevel() == CurrentLevel.SENTENCE){
                count++;
            }
        }
        return count;
    }

    private int longestWordLettersCount(TextComposite sentence){
        HashMap<Integer,TextComposite> words = new HashMap<>();
        for(TextComponent lexeme : sentence.getComponents()){
            for (TextComponent word : sentence.getComponents()){
                if(word.getCurrentLevel() == CurrentLevel.WORD) {
                    words.put(word.build().length(), (TextComposite) word);
                }
            }
        }
        return Collections.max(words.keySet());
    }

    private int countWords(TextComponent sentence){
        int count = 0;
        for(TextComponent lexeme : sentence.getComponents()){
            for (TextComponent word : sentence.getComponents()){
                if(word.getCurrentLevel() == CurrentLevel.WORD) {
                    count++;
                }
            }
        }
        return count;
    }

}

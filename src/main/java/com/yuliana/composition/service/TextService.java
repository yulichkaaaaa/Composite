package com.yuliana.composition.service;

import com.yuliana.composition.entity.TextComponent;
import com.yuliana.composition.entity.TextComposite;

import java.util.List;

public interface TextService {
    TextComposite sortParagraphBySentenceCount(TextComposite text);
    TextComposite searchLongestWordSentences(TextComposite text);
    void deleteSentencesLessWordsCount(TextComposite text, int wordsCount);
    int searchSameWordsRegisterIndependent(TextComposite composite);
}

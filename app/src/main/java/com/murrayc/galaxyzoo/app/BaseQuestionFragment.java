package com.murrayc.galaxyzoo.app;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;

/**
 * Created by murrayc on 8/28/14.
 */
public class BaseQuestionFragment extends ItemFragment {
    public static final String ARG_QUESTION_ID = "question-id";
    private String mQuestionId;

    public String getQuestionId() {
        return mQuestionId;
    }

    public void setQuestionId(final String questionId) {
        mQuestionId = questionId;
    }

    protected DecisionTree.Question getQuestion() {
        final Singleton singleton = getSingleton();
        final DecisionTree tree = singleton.getDecisionTree();

        DecisionTree.Question question = tree.getQuestionOrFirst(getQuestionId());
        setQuestionId(question.getId());
        return question;
    }

    protected BitmapDrawable getIcon(final Context context, final DecisionTree.BaseButton answer) {
        final Singleton singleton = getSingleton();
        return singleton.getIconDrawable(context, answer);
    }
}
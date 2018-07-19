package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mTextView;
    Button mButtonTop;
    Button mButtonBottom;
    Button mButtonRestart;
    StoryNode mCurrentStoryNode;

    private StoryNode[] mStoryNodes = new StoryNode[]{
            new StoryNode(R.string.T1_Story,R.string.T1_Ans1,R.string.T1_Ans2,R.string.T3_Story,R.string.T2_Story),
            new StoryNode(R.string.T2_Story,R.string.T2_Ans1,R.string.T2_Ans2,R.string.T3_Story,R.string.T4_End),
            new StoryNode(R.string.T3_Story,R.string.T3_Ans1,R.string.T3_Ans2,R.string.T6_End,R.string.T5_End),
            new StoryNode(R.string.T4_End),
            new StoryNode(R.string.T5_End),
            new StoryNode(R.string.T6_End)

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCurrentStoryNode = mStoryNodes[0];

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mTextView = findViewById(R.id.storyTextView);
        mButtonTop = findViewById(R.id.buttonTop);
        mButtonBottom = findViewById(R.id.buttonBottom);
        mButtonRestart = findViewById(R.id.buttonRestart);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadNextStory("top");
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadNextStory("bottom");
            }
        });

        mButtonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mButtonRestart.setVisibility(View.INVISIBLE);
                mButtonTop.setVisibility(View.VISIBLE);
                mButtonBottom.setVisibility(View.VISIBLE);
                //Reset story to first node
                mCurrentStoryNode = mStoryNodes[0];
                mTextView.setText(mCurrentStoryNode.getStoryResId());
                mButtonTop.setText(mCurrentStoryNode.getAnsTopResId());
                mButtonBottom.setText(mCurrentStoryNode.getAnsBottomResId());
            }
        });

    }

    private void loadNextStory(String choice){
        int nextStory;
        if (choice.equals("top")){
            nextStory = mCurrentStoryNode.getPathTopResId();
        }else{//If choice == bottom
            nextStory = mCurrentStoryNode.getPathBottomResId();
        }
        //Get next storyNode
        for (StoryNode storyNode : mStoryNodes) {
            if(storyNode.getStoryResId() == nextStory) {
                mCurrentStoryNode = storyNode;
            }
        }


        if (mCurrentStoryNode.isEnd() == false) {
            //Load next story and buttons into view
            mTextView.setText(mCurrentStoryNode.getStoryResId());
            mButtonTop.setText(mCurrentStoryNode.getAnsTopResId());
            mButtonBottom.setText(mCurrentStoryNode.getAnsBottomResId());
        }else{//If currentStoryNode is an ending node
            //Load next story, set buttons to invisible and show restart button
            mTextView.setText(mCurrentStoryNode.getStoryResId());
            mButtonTop.setVisibility(View.INVISIBLE);
            mButtonBottom.setVisibility(View.INVISIBLE);
            mButtonRestart.setVisibility(View.VISIBLE);
        }

    }
}

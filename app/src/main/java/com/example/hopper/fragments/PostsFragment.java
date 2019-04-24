package com.example.hopper.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hopper.Post;
import com.example.hopper.PostsAdapter;
import com.example.hopper.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class PostsFragment extends Fragment {

    private SwipeRefreshLayout swipeContainer;

    public static final String TAG = "PostsFragment";

    private RecyclerView rvPosts;
    protected PostsAdapter adapter;
    protected List<Post> mPosts;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_feed, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        rvPosts = view.findViewById(R.id.rvFeed);

        // create the data source
        mPosts = new ArrayList<>();
        // create the adapter
        adapter = new PostsAdapter(getContext(), mPosts);
        // set the adapter on the recycler view
        rvPosts.setAdapter(adapter);
        // set the layout manager on the recycler view
        rvPosts.setLayoutManager(new LinearLayoutManager(getContext()));
        queryPosts();

        swipeContainer = (SwipeRefreshLayout) view.findViewById(R.id.swipeContainer);
        // Setup refresh listener which triggers new data loading
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.
                Log.d("ParseIG", "Context is being refreshed");
                queryPosts();
            }
        });

    }

    protected void queryPosts() {
        ParseQuery<Post> postQueuery = new ParseQuery<Post>(Post.class);
        postQueuery.include(Post.KEY_BUSINESS_NAME);
        postQueuery.setLimit(20);
//        postQueuery.addDescendingOrder(Post.KEY_CREATED_AT);
        postQueuery.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "ERROR WITH QUERY");
                    e.printStackTrace();
                    return;
                }

                for (int i = 0; i < posts.size(); i++) {
                    Post post = posts.get(i);
                    Log.d(TAG, "Posts " + post.getDescription() + ", username: " + post.getUser());
                }
                // Show the data we just recieved
                // Now we call setRefreshing(false) to signal refresh has finished
                adapter.clear();
                mPosts.addAll(posts);
                adapter.notifyDataSetChanged();
                swipeContainer.setRefreshing(false);
            }
        });
    }
}


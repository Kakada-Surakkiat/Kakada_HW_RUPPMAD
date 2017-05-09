package kh.edu.rupp.fe.ruppmad;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import kh.edu.rupp.fe.ruppmad.adapter.Assignment;
import kh.edu.rupp.fe.ruppmad.adapter.AssignmentAdapter;

/**
 * Created by Kakada_Surakkiat on 5/9/2017.
 */

public class AssignmentFragment extends Fragment {

    private RecyclerView recyclerView;
    private AssignmentAdapter assignmentAdapter;
    private List<Assignment> assignmentsList;
    private Database myDatabase;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_assignment, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.rcl_assignment);
        assignmentsList = new ArrayList<>();
        myDatabase = new Database(getActivity());

        long timestampMillis = System.currentTimeMillis();
        String currentDateTimeString = String.valueOf(timestampMillis);


        myDatabase.insertAssignment("History", currentDateTimeString, "http://study.com/cimages/course-image/mtel-history-practice-study-guide_172249_large.jpg", "abc");
        myDatabase.insertAssignment("Khmer", currentDateTimeString, "http://study.com/cimages/course-image/mtel-history-practice-study-guide_172249_large.jpg", "abc");
        myDatabase.insertAssignment("English", currentDateTimeString, "http://study.com/cimages/course-image/mtel-history-practice-study-guide_172249_large.jpg", "abc");
        myDatabase.insertAssignment("Physic", currentDateTimeString, "http://study.com/cimages/course-image/mtel-history-practice-study-guide_172249_large.jpg", "abc");
        myDatabase.insertAssignment("Technology", currentDateTimeString, "http://study.com/cimages/course-image/mtel-history-practice-study-guide_172249_large.jpg", "abc");
        myDatabase.insertAssignment("Computer", currentDateTimeString, "http://study.com/cimages/course-image/mtel-history-practice-study-guide_172249_large.jpg", "abc");


        if (myDatabase.getAssignmentData() != null) {
            assignmentsList = myDatabase.getAssignmentData();
        }

        assignmentAdapter = new AssignmentAdapter(getActivity(), assignmentsList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(assignmentAdapter);

        return view;
    }
}

package kh.edu.rupp.fe.ruppmad.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kh.edu.rupp.fe.ruppmad.R;

/**
 * Created by Kakada_Surakkiat on 5/9/2017.
 */

public class AssignmentAdapter extends RecyclerView.Adapter<AssignmentAdapter.DocumentViewHolder> {

    private Context mContext;
    private List<Assignment> assignmentList;

    public AssignmentAdapter(Context mContext, List<Assignment> assignmentList) {
        this.mContext = mContext;
        this.assignmentList = assignmentList;
    }

    @Override
    public DocumentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        DocumentViewHolder documentViewHolder = new DocumentViewHolder(LayoutInflater.from(mContext).inflate(R.layout.viewholder_assignment, parent, false));

        return documentViewHolder;
    }

    @Override
    public void onBindViewHolder(DocumentViewHolder holder, int position) {

        long yourmilliseconds = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        Date resultdate = new Date(yourmilliseconds);
//        System.out.println(sdf.format(resultdate));

        holder.textViewTitle.setText(assignmentList.get(position).getTitle());
        holder.textViewDeadline.setText(resultdate.toString());

    }

    @Override
    public int getItemCount() {
        return assignmentList.size();
    }

    public class DocumentViewHolder extends RecyclerView.ViewHolder{

        ImageView imageViewThumbnail;
        TextView textViewTitle, textViewDeadline;

        public DocumentViewHolder(View itemView) {
            super(itemView);

            imageViewThumbnail = (ImageView) itemView.findViewById(R.id.img_ass_thumbnail);
            textViewTitle = (TextView) itemView.findViewById(R.id.txt_ass_title);
            textViewDeadline = (TextView) itemView.findViewById(R.id.txt_ass_deadline);

        }
    }

}

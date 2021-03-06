package kangxiaoling.bwie.com.fangjingdong.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import kangxiaoling.bwie.com.fangjingdong.R;
import kangxiaoling.bwie.com.fangjingdong.entity.user.SYBean;

/**
 * Created by ll on 2018/9/7.
 */

class TuiAdapter extends RecyclerView.Adapter<TuiAdapter.TuiViewHolder>{
    private Context context;
    private SYBean.DataBean data;
    private final List<SYBean.DataBean.TuijianBean.ListBeanX> list;

    public TuiAdapter(Context context, SYBean.DataBean data) {
        this.context = context;
        this.data = data;
        list = data.getTuijian().getList();
    }

    @Override
    public TuiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tui_layout, parent, false);
        return new TuiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TuiViewHolder holder, int position) {
        holder.tui_text.setText(list.get(position).getTitle());
        Uri uri = Uri.parse(list.get(position).getImages().split("\\|")[0]);
        holder.tui_img.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TuiViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView tui_img;
        private TextView tui_text;

        public TuiViewHolder(View itemView) {
            super(itemView);
            tui_img = (SimpleDraweeView) itemView.findViewById(R.id.tui_img);
            tui_text = (TextView) itemView.findViewById(R.id.tui_text);
        }
    }
}

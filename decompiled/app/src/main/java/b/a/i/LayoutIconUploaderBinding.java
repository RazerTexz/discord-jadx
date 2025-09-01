package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.discord.R;
import com.facebook.drawee.view.SimpleDraweeView;

/* compiled from: LayoutIconUploaderBinding.java */
/* renamed from: b.a.i.r0, reason: use source file name */
/* loaded from: classes.dex */
public final class LayoutIconUploaderBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f190b;

    @NonNull
    public final Group c;

    public LayoutIconUploaderBinding(@NonNull ConstraintLayout constraintLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull ImageView imageView3, @NonNull Group group) {
        this.a = constraintLayout;
        this.f190b = simpleDraweeView;
        this.c = group;
    }

    @NonNull
    public static LayoutIconUploaderBinding a(@NonNull View view) {
        int i = R.id.icon_uploader_image;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.icon_uploader_image);
        if (simpleDraweeView != null) {
            i = R.id.icon_uploader_placeholder_border;
            ImageView imageView = (ImageView) view.findViewById(R.id.icon_uploader_placeholder_border);
            if (imageView != null) {
                i = R.id.icon_uploader_placeholder_icon;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.icon_uploader_placeholder_icon);
                if (imageView2 != null) {
                    i = R.id.icon_uploader_placeholder_text;
                    TextView textView = (TextView) view.findViewById(R.id.icon_uploader_placeholder_text);
                    if (textView != null) {
                        i = R.id.icon_uploader_plus;
                        ImageView imageView3 = (ImageView) view.findViewById(R.id.icon_uploader_plus);
                        if (imageView3 != null) {
                            i = R.id.placeholder_group;
                            Group group = (Group) view.findViewById(R.id.placeholder_group);
                            if (group != null) {
                                return new LayoutIconUploaderBinding((ConstraintLayout) view, simpleDraweeView, imageView, imageView2, textView, imageView3, group);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}

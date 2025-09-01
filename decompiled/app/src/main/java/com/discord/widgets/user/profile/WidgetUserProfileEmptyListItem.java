package com.discord.widgets.user.profile;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.StringRes;
import androidx.exifinterface.media.ExifInterface;
import com.discord.R;
import com.discord.databinding.WidgetUserProfileAdapterItemEmptyBinding;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetUserProfileEmptyListItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00010\u0001*\u0004\b\u0001\u0010\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004B-\u0012\b\b\u0001\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00028\u0000\u0012\b\b\u0001\u0010\u000b\u001a\u00020\b\u0012\b\b\u0001\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/user/profile/WidgetUserProfileEmptyListItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "D", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/databinding/WidgetUserProfileAdapterItemEmptyBinding;", "binding", "Lcom/discord/databinding/WidgetUserProfileAdapterItemEmptyBinding;", "", "layout", "adapter", "backgroundImageRes", "message", "<init>", "(ILcom/discord/utilities/mg_recycler/MGRecyclerAdapter;II)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetUserProfileEmptyListItem<T extends MGRecyclerAdapter<D>, D> extends MGRecyclerViewHolder<T, D> {
    private final WidgetUserProfileAdapterItemEmptyBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserProfileEmptyListItem(@LayoutRes int i, T t, @AttrRes int i2, @StringRes int i3) {
        super(i, t);
        Intrinsics3.checkNotNullParameter(t, "adapter");
        View view = this.itemView;
        int i4 = R.id.user_profile_adapter_item_empty;
        ImageView imageView = (ImageView) view.findViewById(R.id.user_profile_adapter_item_empty);
        if (imageView != null) {
            i4 = R.id.user_profile_adapter_item_empty_text;
            TextView textView = (TextView) view.findViewById(R.id.user_profile_adapter_item_empty_text);
            if (textView != null) {
                WidgetUserProfileAdapterItemEmptyBinding widgetUserProfileAdapterItemEmptyBinding = new WidgetUserProfileAdapterItemEmptyBinding((LinearLayout) view, imageView, textView);
                Intrinsics3.checkNotNullExpressionValue(widgetUserProfileAdapterItemEmptyBinding, "WidgetUserProfileAdapter…ptyBinding.bind(itemView)");
                this.binding = widgetUserProfileAdapterItemEmptyBinding;
                View view2 = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
                imageView.setBackgroundResource(DrawableCompat.getThemedDrawableRes$default(view2, i2, 0, 2, (Object) null));
                textView.setText(i3);
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }
}

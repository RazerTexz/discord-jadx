package com.discord.widgets.servers.community;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import com.discord.R;
import com.discord.databinding.ViewCommunityGetStartedHeaderBinding;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CommunityGetStartedHeaderIconView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/servers/community/CommunityGetStartedHeaderIconView;", "Landroidx/cardview/widget/CardView;", "Landroid/util/AttributeSet;", "attrs", "", "initAttrs", "(Landroid/util/AttributeSet;)V", "Lcom/discord/databinding/ViewCommunityGetStartedHeaderBinding;", "binding", "Lcom/discord/databinding/ViewCommunityGetStartedHeaderBinding;", "Landroid/content/Context;", "context", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class CommunityGetStartedHeaderIconView extends CardView {
    private final ViewCommunityGetStartedHeaderBinding binding;

    public CommunityGetStartedHeaderIconView(Context context) {
        this(context, null, 0, 6, null);
    }

    public CommunityGetStartedHeaderIconView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ CommunityGetStartedHeaderIconView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void initAttrs(AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.a.CommunityGetStartedHeaderIconView, 0, 0);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…rtedHeaderIconView, 0, 0)");
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        CharSequence text = typedArrayObtainStyledAttributes.getText(1);
        typedArrayObtainStyledAttributes.recycle();
        this.binding.f2181b.setImageDrawable(AppCompatResources.getDrawable(getContext(), resourceId));
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.communityGetStartedHeaderIconText");
        textView.setText(text);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommunityGetStartedHeaderIconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.view_community_get_started_header, this);
        int i2 = R.id.community_get_started_header_icon;
        ImageView imageView = (ImageView) findViewById(R.id.community_get_started_header_icon);
        if (imageView != null) {
            i2 = R.id.community_get_started_header_icon_text;
            TextView textView = (TextView) findViewById(R.id.community_get_started_header_icon_text);
            if (textView != null) {
                ViewCommunityGetStartedHeaderBinding viewCommunityGetStartedHeaderBinding = new ViewCommunityGetStartedHeaderBinding(this, imageView, textView);
                Intrinsics3.checkNotNullExpressionValue(viewCommunityGetStartedHeaderBinding, "ViewCommunityGetStartedH…ater.from(context), this)");
                this.binding = viewCommunityGetStartedHeaderBinding;
                if (attributeSet != null) {
                    initAttrs(attributeSet);
                    return;
                }
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i2)));
    }
}

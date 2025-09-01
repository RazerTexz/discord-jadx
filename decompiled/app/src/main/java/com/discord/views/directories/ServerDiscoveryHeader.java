package com.discord.views.directories;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.ViewServerDiscoveryHeaderBinding;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ServerDiscoveryHeader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/discord/views/directories/ServerDiscoveryHeader;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "title", "", "setTitle", "(Ljava/lang/CharSequence;)V", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "setDescription", "Landroid/view/View$OnClickListener;", "listener", "setButtonOnClickListener", "(Landroid/view/View$OnClickListener;)V", "Lb/a/i/f3;", "j", "Lb/a/i/f3;", "binding", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ServerDiscoveryHeader extends ConstraintLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final ViewServerDiscoveryHeaderBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerDiscoveryHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.view_server_discovery_header, this);
        int i = R.id.server_discovery_header_description;
        TextView textView = (TextView) findViewById(R.id.server_discovery_header_description);
        if (textView != null) {
            i = R.id.server_discovery_header_image;
            ImageView imageView = (ImageView) findViewById(R.id.server_discovery_header_image);
            if (imageView != null) {
                i = R.id.server_discovery_header_search_layout;
                FrameLayout frameLayout = (FrameLayout) findViewById(R.id.server_discovery_header_search_layout);
                if (frameLayout != null) {
                    i = R.id.server_discovery_header_title;
                    TextView textView2 = (TextView) findViewById(R.id.server_discovery_header_title);
                    if (textView2 != null) {
                        ViewServerDiscoveryHeaderBinding viewServerDiscoveryHeaderBinding = new ViewServerDiscoveryHeaderBinding(this, textView, imageView, frameLayout, textView2);
                        Intrinsics3.checkNotNullExpressionValue(viewServerDiscoveryHeaderBinding, "ViewServerDiscoveryHeade…ater.from(context), this)");
                        this.binding = viewServerDiscoveryHeaderBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public final void setButtonOnClickListener(View.OnClickListener listener) {
        this.binding.c.setOnClickListener(listener);
    }

    public final void setDescription(CharSequence description) {
        TextView textView = this.binding.f112b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverDiscoveryHeaderDescription");
        textView.setText(description);
    }

    public final void setTitle(CharSequence title) {
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverDiscoveryHeaderTitle");
        textView.setText(title);
    }
}

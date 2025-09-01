package com.discord.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import b.a.i.ViewStreamPreviewBinding;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.stores.StoreApplicationStreamPreviews;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: StreamPreviewView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\nJ'\u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001e"}, d2 = {"Lcom/discord/views/StreamPreviewView;", "Landroid/widget/FrameLayout;", "", "url", "", "setImage", "(Ljava/lang/String;)V", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "setCaptionText", "(Ljava/lang/CharSequence;)V", "setOverlayCaptionText", "Lcom/discord/stores/StoreApplicationStreamPreviews$StreamPreview;", "preview", "Lcom/discord/utilities/streams/StreamContext$Joinability;", "joinability", "", "isAlreadyWatchingStream", "a", "(Lcom/discord/stores/StoreApplicationStreamPreviews$StreamPreview;Lcom/discord/utilities/streams/StreamContext$Joinability;Z)V", "Lb/a/i/z3;", "j", "Lb/a/i/z3;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StreamPreviewView extends FrameLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final ViewStreamPreviewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamPreviewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.view_stream_preview, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.stream_preview_image;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R.id.stream_preview_image);
        if (simpleDraweeView != null) {
            i = R.id.stream_preview_overlay_text;
            TextView textView = (TextView) viewInflate.findViewById(R.id.stream_preview_overlay_text);
            if (textView != null) {
                i = R.id.stream_preview_placeholder_caption;
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.stream_preview_placeholder_caption);
                if (textView2 != null) {
                    ViewStreamPreviewBinding viewStreamPreviewBinding = new ViewStreamPreviewBinding((ConstraintLayout) viewInflate, simpleDraweeView, textView, textView2);
                    Intrinsics3.checkNotNullExpressionValue(viewStreamPreviewBinding, "ViewStreamPreviewBinding…rom(context), this, true)");
                    this.binding = viewStreamPreviewBinding;
                    setClickable(true);
                    setFocusable(false);
                    setFocusableInTouchMode(false);
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    private final void setCaptionText(CharSequence text) {
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.streamPreviewPlaceholderCaption");
        ViewExtensions.setTextAndVisibilityBy(textView, text);
    }

    private final void setImage(String url) {
        this.binding.f240b.setImageURI(url);
    }

    private final void setOverlayCaptionText(CharSequence text) {
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.streamPreviewOverlayText");
        ViewExtensions.setTextAndVisibilityBy(textView, text);
    }

    @MainThread
    public final void a(StoreApplicationStreamPreviews.StreamPreview preview, StreamContext.Joinability joinability, boolean isAlreadyWatchingStream) {
        Intrinsics3.checkNotNullParameter(preview, "preview");
        Intrinsics3.checkNotNullParameter(joinability, "joinability");
        if (preview instanceof StoreApplicationStreamPreviews.StreamPreview.Fetching) {
            setCaptionText(getContext().getString(R.string.stream_preview_loading));
        } else {
            if (!(preview instanceof StoreApplicationStreamPreviews.StreamPreview.Resolved)) {
                throw new NoWhenBranchMatchedException();
            }
            StoreApplicationStreamPreviews.StreamPreview.Resolved resolved = (StoreApplicationStreamPreviews.StreamPreview.Resolved) preview;
            if (resolved.getUrl() != null) {
                setImage(resolved.getUrl());
                setCaptionText(null);
            } else {
                setImage(null);
                if (joinability == StreamContext.Joinability.CAN_CONNECT) {
                    setCaptionText(getContext().getString(R.string.stream_no_preview));
                } else {
                    setCaptionText(null);
                }
            }
        }
        if (isAlreadyWatchingStream) {
            setOverlayCaptionText(FormatUtils.j(this, R.string.watch_stream_watching, new Object[0], null, 4));
            return;
        }
        int iOrdinal = joinability.ordinal();
        if (iOrdinal == 0) {
            setOverlayCaptionText(FormatUtils.j(this, R.string.join_stream, new Object[0], null, 4));
        } else if (iOrdinal == 1) {
            setOverlayCaptionText(FormatUtils.j(this, R.string.unable_to_join_channel_full, new Object[0], null, 4));
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            setOverlayCaptionText(FormatUtils.j(this, R.string.channel_locked_short, new Object[0], null, 4));
        }
    }
}

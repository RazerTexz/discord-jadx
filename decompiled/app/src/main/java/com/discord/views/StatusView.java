package com.discord.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Px;
import androidx.appcompat.widget.AppCompatImageView;
import com.discord.R;
import com.discord.api.presence.ClientStatus;
import com.discord.api.presence.ClientStatuses;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.presence.Presence;
import com.discord.utilities.presence.PresenceUtils;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: StatusView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\b%\u0010&J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\b\b\u0001\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\nJ\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006'"}, d2 = {"Lcom/discord/views/StatusView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/discord/models/presence/Presence;", "presence", "", "setPresence", "(Lcom/discord/models/presence/Presence;)V", "", "borderWidthPx", "setBorderWidth", "(I)V", "", "cornerRadius", "setCornerRadius", "(F)V", ModelAuditLogEntry.CHANGE_KEY_COLOR, "setBackgroundColor", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "", "l", "Z", "showMobile", "Landroid/graphics/Paint;", "k", "Landroid/graphics/Paint;", "backgroundPaint", "m", "isCircle", "j", "F", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StatusView extends AppCompatImageView {

    /* renamed from: j, reason: from kotlin metadata */
    public float cornerRadius;

    /* renamed from: k, reason: from kotlin metadata */
    public Paint backgroundPaint;

    /* renamed from: l, reason: from kotlin metadata */
    public boolean showMobile;

    /* renamed from: m, reason: from kotlin metadata */
    public boolean isCircle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.cornerRadius = 2.0f;
        this.showMobile = true;
        this.isCircle = true;
        setAdjustViewBounds(true);
        setScaleType(ImageView.ScaleType.FIT_XY);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.a.StatusView, 0, 0);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…yleable.StatusView, 0, 0)");
        try {
            setBorderWidth((int) typedArrayObtainStyledAttributes.getDimension(1, 0.0f));
            int color = typedArrayObtainStyledAttributes.getColor(0, 0);
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(color);
            paint.setAntiAlias(true);
            this.backgroundPaint = paint;
            this.showMobile = typedArrayObtainStyledAttributes.getBoolean(3, true);
            this.cornerRadius = typedArrayObtainStyledAttributes.getDimension(2, 0.0f);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics3.checkNotNullParameter(canvas, "canvas");
        if (this.isCircle) {
            float width = getWidth() / 2.0f;
            float height = getHeight() / 2.0f;
            float width2 = getWidth() / 2.0f;
            Paint paint = this.backgroundPaint;
            if (paint == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("backgroundPaint");
            }
            canvas.drawCircle(width, height, width2, paint);
        } else {
            float width3 = getWidth();
            float height2 = getHeight();
            float f = this.cornerRadius;
            Paint paint2 = this.backgroundPaint;
            if (paint2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("backgroundPaint");
            }
            canvas.drawRoundRect(0.0f, 0.0f, width3, height2, f, f, paint2);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);
        paint.setAntiAlias(true);
        this.backgroundPaint = paint;
    }

    public final void setBorderWidth(@Px int borderWidthPx) {
        setPadding(borderWidthPx, borderWidthPx, borderWidthPx, borderWidthPx);
    }

    public final void setCornerRadius(@Px float cornerRadius) {
        this.cornerRadius = cornerRadius;
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setPresence(Presence presence) {
        int i;
        ClientStatuses clientStatuses;
        ClientStatuses clientStatuses2;
        if (!this.showMobile || presence == null || (clientStatuses2 = presence.getClientStatuses()) == null || !PresenceUtils.INSTANCE.isMobile(clientStatuses2)) {
            if ((presence != null ? PresenceUtils.INSTANCE.getStreamingActivity(presence) : null) != null) {
                i = R.drawable.ic_status_streaming_16dp;
            } else {
                ClientStatus status = presence != null ? presence.getStatus() : null;
                if (status != null) {
                    int iOrdinal = status.ordinal();
                    i = iOrdinal != 0 ? iOrdinal != 1 ? iOrdinal != 2 ? R.drawable.ic_status_invisible_16dp : R.drawable.ic_status_dnd_16dp : R.drawable.ic_status_idle_16dp : R.drawable.ic_status_online_16dp;
                }
            }
        } else {
            i = R.drawable.ic_mobile;
        }
        setImageResource(i);
        this.isCircle = !(this.showMobile && presence != null && (clientStatuses = presence.getClientStatuses()) != null && PresenceUtils.INSTANCE.isMobile(clientStatuses));
    }
}

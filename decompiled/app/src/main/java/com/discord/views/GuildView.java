package com.discord.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import b.a.i.ViewGuildBinding;
import b.f.g.f.RoundingParams;
import com.discord.R;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GuildView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/discord/views/GuildView;", "Landroid/widget/FrameLayout;", "Lb/f/g/f/c;", "roundingParams", "", "setRoundingParams", "(Lb/f/g/f/c;)V", "", "iconUrl", "shortGuildName", "a", "(Ljava/lang/String;Ljava/lang/String;)V", "b", "()V", "Lb/a/i/k2;", "k", "Lb/a/i/k2;", "binding", "", "m", "I", "textSize", "l", "targetImageSize", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildView extends FrameLayout {
    public static final /* synthetic */ int j = 0;

    /* renamed from: k, reason: from kotlin metadata */
    public final ViewGuildBinding binding;

    /* renamed from: l, reason: from kotlin metadata */
    public int targetImageSize;

    /* renamed from: m, reason: from kotlin metadata */
    public int textSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.view_guild, this);
        int i = R.id.guild_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.guild_avatar);
        if (simpleDraweeView != null) {
            i = R.id.guild_text;
            TextView textView = (TextView) findViewById(R.id.guild_text);
            if (textView != null) {
                ViewGuildBinding viewGuildBinding = new ViewGuildBinding(this, simpleDraweeView, textView);
                Intrinsics3.checkNotNullExpressionValue(viewGuildBinding, "ViewGuildBinding.inflate…ater.from(context), this)");
                this.binding = viewGuildBinding;
                this.targetImageSize = -1;
                this.textSize = -1;
                setClipToOutline(true);
                setBackgroundResource(R.drawable.drawable_squircle_transparent);
                if (attributeSet != null) {
                    TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.a.GuildView, 0, 0);
                    Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…tyleable.GuildView, 0, 0)");
                    try {
                        this.targetImageSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
                        this.textSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, -1);
                    } finally {
                        typedArrayObtainStyledAttributes.recycle();
                    }
                }
                int i2 = this.textSize;
                if (i2 != -1) {
                    textView.setTextSize(0, i2);
                    return;
                }
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    private final void setRoundingParams(RoundingParams roundingParams) {
        SimpleDraweeView simpleDraweeView = this.binding.f146b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildAvatar");
        GenericDraweeHierarchy hierarchy = simpleDraweeView.getHierarchy();
        Intrinsics3.checkNotNullExpressionValue(hierarchy, "binding.guildAvatar.hierarchy");
        hierarchy.s(roundingParams);
    }

    public final void a(String iconUrl, String shortGuildName) {
        boolean z2 = iconUrl != null;
        int i = this.targetImageSize;
        int mediaProxySize = i != -1 ? IconUtils.getMediaProxySize(i) : 0;
        SimpleDraweeView simpleDraweeView = this.binding.f146b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildAvatar");
        if (!z2) {
            iconUrl = IconUtils.DEFAULT_ICON_BLURPLE;
        }
        MGImages.setImage$default(simpleDraweeView, iconUrl, mediaProxySize, mediaProxySize, false, null, null, 112, null);
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildText");
        textView.setVisibility(true ^ z2 ? 0 : 8);
        TextView textView2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildText");
        textView2.setText(shortGuildName);
    }

    public final void b() {
        RoundingParams roundingParamsA = RoundingParams.a(getResources().getDimensionPixelSize(R.dimen.guild_icon_radius));
        Intrinsics3.checkNotNullExpressionValue(roundingParamsA, "RoundingParams.fromCorne…d_icon_radius).toFloat())");
        setRoundingParams(roundingParamsA);
    }
}

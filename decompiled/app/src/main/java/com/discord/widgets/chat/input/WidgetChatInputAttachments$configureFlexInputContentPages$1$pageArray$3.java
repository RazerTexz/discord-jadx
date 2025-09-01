package com.discord.widgets.chat.input;

import android.content.Context;
import androidx.fragment.app.Fragment;
import b.b.a.d.AddContentPagerAdapter4;
import com.lytefast.flexinput.fragment.CameraFragment;
import kotlin.Metadata;

/* compiled from: WidgetChatInputAttachments.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/discord/widgets/chat/input/WidgetChatInputAttachments$configureFlexInputContentPages$1$pageArray$3", "Lb/b/a/d/d$a;", "Lcom/lytefast/flexinput/fragment/CameraFragment;", "createFragment", "()Lcom/lytefast/flexinput/fragment/CameraFragment;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatInputAttachments$configureFlexInputContentPages$1$pageArray$3 extends AddContentPagerAdapter4.a {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInputAttachments$configureFlexInputContentPages$1$pageArray$3(Context context, int i, int i2) {
        super(i, i2);
        this.$context = context;
    }

    @Override // b.b.a.d.AddContentPagerAdapter4.a
    public /* bridge */ /* synthetic */ Fragment createFragment() {
        return createFragment();
    }

    @Override // b.b.a.d.AddContentPagerAdapter4.a
    public CameraFragment createFragment() {
        return new CameraFragment();
    }
}

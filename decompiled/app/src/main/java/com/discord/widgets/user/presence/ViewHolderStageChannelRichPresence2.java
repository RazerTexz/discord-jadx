package com.discord.widgets.user.presence;

import android.view.View;
import android.widget.Button;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import com.discord.utilities.presence.ActivityUtils2;
import com.discord.utilities.views.ViewCoroutineScope;
import com.discord.widgets.stage.StageChannelJoinHelper;
import kotlin.Metadata;

/* compiled from: ViewHolderStageChannelRichPresence.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/user/presence/ViewHolderStageChannelRichPresence$configureButtonUi$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.presence.ViewHolderStageChannelRichPresence$configureButtonUi$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewHolderStageChannelRichPresence2 implements View.OnClickListener {
    public final /* synthetic */ FragmentManager $fragmentManager$inlined;
    public final /* synthetic */ boolean $isMe$inlined;
    public final /* synthetic */ ActivityUtils2 $partyDerivedData$inlined;
    public final /* synthetic */ Button $this_apply;
    public final /* synthetic */ boolean $userInSameVoiceChannel$inlined;

    public ViewHolderStageChannelRichPresence2(Button button, boolean z2, boolean z3, FragmentManager fragmentManager, ActivityUtils2 activityUtils2) {
        this.$this_apply = button;
        this.$isMe$inlined = z2;
        this.$userInSameVoiceChannel$inlined = z3;
        this.$fragmentManager$inlined = fragmentManager;
        this.$partyDerivedData$inlined = activityUtils2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        StageChannelJoinHelper.lurkAndJoinStage$default(StageChannelJoinHelper.INSTANCE, outline.x(view, "it", "it.context"), this.$fragmentManager$inlined, ViewCoroutineScope.getCoroutineScope(this.$this_apply), this.$partyDerivedData$inlined.getGuildId(), this.$partyDerivedData$inlined.getChannelId(), true, null, null, null, 448, null);
    }
}

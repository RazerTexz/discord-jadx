package com.discord.widgets.user.presence;

import android.content.Context;
import android.view.View;
import com.discord.api.activity.Activity;
import com.discord.models.user.User;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ViewHolderUserRichPresence.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/user/presence/ViewHolderUserRichPresence$configureCustomButtonsUi$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.presence.ViewHolderUserRichPresence$configureCustomButtonsUi$$inlined$forEachIndexed$lambda$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewHolderUserRichPresence2 implements View.OnClickListener {
    public final /* synthetic */ Activity $activity$inlined;
    public final /* synthetic */ List $activityButtons$inlined;
    public final /* synthetic */ Context $applicationContext$inlined;
    public final /* synthetic */ int $index;
    public final /* synthetic */ User $user$inlined;
    public final /* synthetic */ ViewHolderUserRichPresence this$0;

    public ViewHolderUserRichPresence2(int i, ViewHolderUserRichPresence viewHolderUserRichPresence, List list, Context context, User user, Activity activity) {
        this.$index = i;
        this.this$0 = viewHolderUserRichPresence;
        this.$activityButtons$inlined = list;
        this.$applicationContext$inlined = context;
        this.$user$inlined = user;
        this.$activity$inlined = activity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ViewHolderUserRichPresence.access$handleActivityCustomButtonClick(this.this$0, this.$applicationContext$inlined, this.$user$inlined, this.$activity$inlined, this.$index);
    }
}

package com.discord.widgets.voice.fullscreen.grid;

import android.view.View;
import com.discord.widgets.voice.fullscreen.CallParticipant;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: VideoCallGridViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.fullscreen.grid.VideoCallGridViewHolder$UserOrStream$configure$1, reason: use source file name */
/* loaded from: classes.dex */
public final class VideoCallGridViewHolder3 implements View.OnClickListener {
    public final /* synthetic */ CallParticipant.UserOrStreamParticipant $callParticipant;
    public final /* synthetic */ Function1 $onTapped;

    public VideoCallGridViewHolder3(Function1 function1, CallParticipant.UserOrStreamParticipant userOrStreamParticipant) {
        this.$onTapped = function1;
        this.$callParticipant = userOrStreamParticipant;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$onTapped.invoke(this.$callParticipant);
    }
}

package com.discord.widgets.voice.fullscreen;

import android.view.View;
import androidx.activity.OnBackPressedDispatcher;
import com.discord.app.AppActivity;
import com.discord.models.guild.Guild;
import kotlin.Metadata;

/* compiled from: WidgetCallFullscreen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/voice/fullscreen/WidgetCallFullscreen$$special$$inlined$apply$lambda$2", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetCallFullscreen$configureActionBar$$inlined$let$lambda$2 implements View.OnClickListener {
    public final /* synthetic */ Guild $guild$inlined;
    public final /* synthetic */ WidgetCallFullscreen this$0;

    public WidgetCallFullscreen$configureActionBar$$inlined$let$lambda$2(Guild guild, WidgetCallFullscreen widgetCallFullscreen) {
        this.$guild$inlined = guild;
        this.this$0 = widgetCallFullscreen;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        WidgetCallFullscreen.access$getViewModel$p(this.this$0).onVisitCommunityButtonClicked(this.$guild$inlined.getId());
        AppActivity appActivity = this.this$0.getAppActivity();
        if (appActivity == null || (onBackPressedDispatcher = appActivity.getOnBackPressedDispatcher()) == null) {
            return;
        }
        onBackPressedDispatcher.onBackPressed();
    }
}

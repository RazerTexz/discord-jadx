package com.discord.widgets.settings;

import android.view.View;
import b.d.b.a.outline;
import com.discord.app.AppTransitionActivity;
import com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile;
import kotlin.Metadata;

/* compiled from: WidgetSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$1$10 implements View.OnClickListener {
    public static final WidgetSettings$onViewBound$1$10 INSTANCE = new WidgetSettings$onViewBound$1$10();

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetEditUserOrGuildMemberProfile.Companion.launch$default(WidgetEditUserOrGuildMemberProfile.INSTANCE, outline.x(view, "it", "it.context"), AppTransitionActivity.Transition.TYPE_SLIDE_HORIZONTAL, null, 4, null);
    }
}

package com.discord.widgets.guild_role_subscriptions.tier.create;

import b.k.a.a.ColorPickerDialogListener;
import kotlin.Metadata;

/* compiled from: WidgetGuildRoleSubscriptionTierDesign.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\t¨\u0006\u000b¸\u0006\u0000"}, d2 = {"com/discord/widgets/guild_role_subscriptions/tier/create/WidgetGuildRoleSubscriptionTierDesign$launchColorPicker$dialog$1$1", "Lb/k/a/a/f;", "", "dialogId", "selectedColor", "", "onColorSelected", "(II)V", "onColorReset", "(I)V", "onDialogDismissed", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDesign$launchColorPicker$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierDesign2 implements ColorPickerDialogListener {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierDesign this$0;

    public WidgetGuildRoleSubscriptionTierDesign2(WidgetGuildRoleSubscriptionTierDesign widgetGuildRoleSubscriptionTierDesign) {
        this.this$0 = widgetGuildRoleSubscriptionTierDesign;
    }

    @Override // b.k.a.a.ColorPickerDialogListener
    public void onColorReset(int dialogId) {
        WidgetGuildRoleSubscriptionTierDesign.access$getViewModel$p(this.this$0).updateMemberColor(null);
    }

    @Override // b.k.a.a.ColorPickerDialogListener
    public void onColorSelected(int dialogId, int selectedColor) {
        WidgetGuildRoleSubscriptionTierDesign.access$getViewModel$p(this.this$0).updateMemberColor(Integer.valueOf(selectedColor));
    }

    @Override // b.k.a.a.ColorPickerDialogListener
    public void onDialogDismissed(int dialogId) {
    }
}

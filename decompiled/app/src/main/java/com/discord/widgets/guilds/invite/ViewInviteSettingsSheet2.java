package com.discord.widgets.guilds.invite;

import androidx.annotation.IdRes;
import com.discord.R;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: ViewInviteSettingsSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\u000b¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()I", "getTextViewId"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.invite.ViewInviteSettingsSheet$ChannelsSpinnerAdapter$setupViews$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ViewInviteSettingsSheet2 extends Lambda implements Function0<Integer> {
    public final /* synthetic */ boolean $dropDownMode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewInviteSettingsSheet2(boolean z2) {
        super(0);
        this.$dropDownMode = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }

    @IdRes
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        return this.$dropDownMode ? R.id.channel_spinner_dropdown_item_textview : R.id.channel_spinner_item_textview;
    }
}

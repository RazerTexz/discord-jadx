package com.discord.widgets.servers.member_verification;

import android.content.Context;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import com.discord.widgets.servers.member_verification.MemberVerificationRulesAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: MemberVerificationRulesAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "isChecked", "", "onCheckedChanged", "(Landroid/widget/CompoundButton;Z)V", "com/discord/widgets/servers/member_verification/MemberVerificationRulesAdapter$MultipleChoiceItemHolder$createMultipleChoiceButtons$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationRulesAdapter$MultipleChoiceItemHolder$createMultipleChoiceButtons$$inlined$forEach$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class MemberVerificationRulesAdapter2 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ Context $context$inlined;
    public final /* synthetic */ Function1 $onItemSelected$inlined;
    public final /* synthetic */ RadioGroup $radioGroup$inlined;
    public final /* synthetic */ int $valueIndex;
    public final /* synthetic */ List $valueList$inlined;
    public final /* synthetic */ MemberVerificationRulesAdapter.MultipleChoiceItemHolder this$0;

    public MemberVerificationRulesAdapter2(int i, MemberVerificationRulesAdapter.MultipleChoiceItemHolder multipleChoiceItemHolder, List list, RadioGroup radioGroup, Context context, Function1 function1) {
        this.$valueIndex = i;
        this.this$0 = multipleChoiceItemHolder;
        this.$valueList$inlined = list;
        this.$radioGroup$inlined = radioGroup;
        this.$context$inlined = context;
        this.$onItemSelected$inlined = function1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        if (z2) {
            this.$onItemSelected$inlined.invoke(Integer.valueOf(this.$valueIndex));
        }
    }
}

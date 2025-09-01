package com.discord.widgets.channels.list;

import android.content.Context;
import android.view.View;
import com.discord.utilities.guilds.MemberVerificationUtils;
import com.discord.widgets.channels.list.WidgetChannelsListAdapter;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetChannelsListAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemGuildJoinRequest$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ WidgetChannelsListAdapter.ItemGuildJoinRequest this$0;

    /* compiled from: WidgetChannelsListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListAdapter$ItemGuildJoinRequest$onConfigure$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    public WidgetChannelsListAdapter$ItemGuildJoinRequest$onConfigure$1(WidgetChannelsListAdapter.ItemGuildJoinRequest itemGuildJoinRequest, Context context) {
        this.this$0 = itemGuildJoinRequest;
        this.$context = context;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MemberVerificationUtils memberVerificationUtils = MemberVerificationUtils.INSTANCE;
        Context context = this.$context;
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        MemberVerificationUtils.maybeShowVerificationGate$default(memberVerificationUtils, context, WidgetChannelsListAdapter.access$getFragmentManager$p(WidgetChannelsListAdapter.ItemGuildJoinRequest.access$getAdapter$p(this.this$0)), WidgetChannelsListAdapter.ItemGuildJoinRequest.access$getAdapter$p(this.this$0).getSelectedGuildId(), "Channel Notice", null, null, AnonymousClass1.INSTANCE, 48, null);
    }
}

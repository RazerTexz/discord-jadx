package com.discord.widgets.tos;

import android.view.View;
import b.a.d.o;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import kotlin.Metadata;

/* compiled from: WidgetTos.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/tos/WidgetTos$configureAgreementUI$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.tos.WidgetTos$configureAgreementUI$$inlined$with$lambda$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetTos2 implements View.OnClickListener {
    public final /* synthetic */ WidgetTos this$0;

    public WidgetTos2(WidgetTos widgetTos) {
        this.this$0 = widgetTos;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().userAgreements(RestAPIParams.UserAgreements.INSTANCE.agree()), false, 1, null), this.this$0, null, 2, null).k(o.a.g(this.this$0.getContext(), WidgetTos4.INSTANCE, null));
        this.this$0.requireActivity().finish();
    }
}

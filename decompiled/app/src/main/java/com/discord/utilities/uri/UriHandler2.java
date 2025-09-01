package com.discord.utilities.uri;

import android.view.View;
import b.a.d.AppToast;
import b.d.b.a.outline;
import com.discord.databinding.LayoutUnhandledUriBinding;
import kotlin.Metadata;

/* compiled from: UriHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "v", "", "onClick", "(Landroid/view/View;)V", "com/discord/utilities/uri/UriHandler$showUnhandledUrlDialog$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.uri.UriHandler$showUnhandledUrlDialog$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class UriHandler2 implements View.OnClickListener {
    public final /* synthetic */ LayoutUnhandledUriBinding $binding$inlined;
    public final /* synthetic */ String $url$inlined;

    public UriHandler2(LayoutUnhandledUriBinding layoutUnhandledUriBinding, String str) {
        this.$binding$inlined = layoutUnhandledUriBinding;
        this.$url$inlined = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AppToast.c(outline.x(view, "v", "v.context"), this.$url$inlined, 0, 4);
    }
}

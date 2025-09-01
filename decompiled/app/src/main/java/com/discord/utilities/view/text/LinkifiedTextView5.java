package com.discord.utilities.view.text;

import com.discord.utilities.logging.Logger;
import com.discord.utilities.logging.LoggingProvider;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: LinkifiedTextView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/utilities/logging/Logger;", "invoke", "()Lcom/discord/utilities/logging/Logger;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.view.text.LinkifiedTextView$Companion$logger$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class LinkifiedTextView5 extends Lambda implements Function0<Logger> {
    public static final LinkifiedTextView5 INSTANCE = new LinkifiedTextView5();

    public LinkifiedTextView5() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Logger invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Logger invoke() {
        return LoggingProvider.INSTANCE.get();
    }
}

package com.discord.utilities.textprocessing;

import android.text.style.TextAppearanceSpan;
import androidx.exifinterface.media.ExifInterface;
import com.discord.R;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.utilities.textprocessing.node.BasicRenderContext;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: Rules.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0003\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0004\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/utilities/textprocessing/node/BasicRenderContext;", "RC", "Lcom/discord/utilities/textprocessing/Rules$BlockQuoteState;", ExifInterface.LATITUDE_SOUTH, "it", "", "get", "(Lcom/discord/utilities/textprocessing/node/BasicRenderContext;)Ljava/lang/Iterable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class Rules$createCodeBlockRule$codeStyleProviders$5<RC> implements StyleNode.a<RC> {
    public static final Rules$createCodeBlockRule$codeStyleProviders$5 INSTANCE = new Rules$createCodeBlockRule$codeStyleProviders$5();

    @Override // com.discord.simpleast.core.node.StyleNode.a
    public /* bridge */ /* synthetic */ Iterable get(Object obj) {
        return get((BasicRenderContext) obj);
    }

    /* JADX WARN: Incorrect types in method signature: (TRC;)Ljava/lang/Iterable<*>; */
    public final Iterable get(BasicRenderContext basicRenderContext) {
        Intrinsics3.checkNotNullParameter(basicRenderContext, "it");
        return CollectionsJVM.listOf(new TextAppearanceSpan(basicRenderContext.getContext(), R.style.Code_TextAppearance_Identifier));
    }
}

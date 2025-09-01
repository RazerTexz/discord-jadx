package com.discord.utilities.textprocessing;

import android.text.style.ParagraphStyle;
import com.discord.utilities.spans.BulletSpan;
import com.discord.utilities.spans.VerticalPaddingSpan;
import d0.t.Collections2;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: ChangelogSpans.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Landroid/text/style/ParagraphStyle;", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.textprocessing.ChangelogSpans$createMarkdownBulletSpansProvider$1$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ChangelogSpans2 extends Lambda implements Function0<List<? extends ParagraphStyle>> {
    public final /* synthetic */ int $bulletColor;
    public final /* synthetic */ int $bulletGapWidth;
    public final /* synthetic */ int $bulletVerticalPadding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChangelogSpans2(int i, int i2, int i3) {
        super(0);
        this.$bulletVerticalPadding = i;
        this.$bulletGapWidth = i2;
        this.$bulletColor = i3;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends ParagraphStyle> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends ParagraphStyle> invoke2() {
        int i = this.$bulletVerticalPadding;
        return Collections2.listOf((Object[]) new ParagraphStyle[]{new VerticalPaddingSpan(i, i), new BulletSpan(this.$bulletGapWidth, this.$bulletColor, 8, 0.0f, null, 24, null)});
    }
}

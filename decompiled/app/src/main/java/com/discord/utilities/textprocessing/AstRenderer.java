package com.discord.utilities.textprocessing;

import android.text.SpannableStringBuilder;
import androidx.exifinterface.media.ExifInterface;
import b.a.t.b.b.SimpleRenderer;
import com.discord.simpleast.core.node.Node;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import kotlin.Metadata;

/* compiled from: AstRenderer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J1\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00032\u0006\u0010\u0006\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/discord/utilities/textprocessing/AstRenderer;", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/discord/simpleast/core/node/Node;", "ast", "renderContext", "Lcom/facebook/drawee/span/DraweeSpanStringBuilder;", "render", "(Ljava/util/Collection;Ljava/lang/Object;)Lcom/facebook/drawee/span/DraweeSpanStringBuilder;", "Landroid/text/SpannableStringBuilder;", "builder", "", "trim", "(Landroid/text/SpannableStringBuilder;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class AstRenderer {
    public static final AstRenderer INSTANCE = new AstRenderer();

    private AstRenderer() {
    }

    public static final <T> DraweeSpanStringBuilder render(Collection<? extends Node<T>> ast, T renderContext) {
        Intrinsics3.checkNotNullParameter(ast, "ast");
        DraweeSpanStringBuilder draweeSpanStringBuilder = new DraweeSpanStringBuilder();
        SimpleRenderer.a(draweeSpanStringBuilder, ast, renderContext);
        INSTANCE.trim(draweeSpanStringBuilder);
        return draweeSpanStringBuilder;
    }

    private final void trim(SpannableStringBuilder builder) {
        if (builder.length() == 0) {
            return;
        }
        char[] cArr = new char[1];
        builder.getChars(builder.length() - 1, builder.length(), cArr, 0);
        if (cArr[0] == '\n') {
            builder.delete(builder.length() - 1, builder.length());
        }
    }
}

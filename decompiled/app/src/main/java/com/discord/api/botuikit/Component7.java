package com.discord.api.botuikit;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: Component.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ=\u0010\t\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/discord/api/botuikit/ComponentUtils;", "", "", "Lcom/discord/api/botuikit/Component;", "", "startIndex", "Lkotlin/Function2;", "", "action", "a", "(Ljava/util/List;ILkotlin/jvm/functions/Function2;)I", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.botuikit.ComponentUtils, reason: use source file name */
/* loaded from: classes.dex */
public final class Component7 {
    public static final Component7 INSTANCE = new Component7();

    public final int a(List<? extends Component> list, int i, Function2<? super Integer, ? super Component, Unit> function2) {
        for (Component component : list) {
            Integer numValueOf = Integer.valueOf(i);
            i++;
            function2.invoke(numValueOf, component);
            if (component instanceof Component8) {
                i = a(((Component8) component).a(), i, function2);
            }
        }
        return i;
    }
}

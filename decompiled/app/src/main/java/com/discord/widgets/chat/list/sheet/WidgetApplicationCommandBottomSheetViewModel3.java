package com.discord.widgets.chat.list.sheet;

import com.discord.api.commands.ApplicationCommandData3;
import d0.g0.Strings4;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001d\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000*\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0004\u001a\u0013\u0010\u0007\u001a\u00020\u0006*\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", "Lcom/discord/api/commands/ApplicationCommandValue;", "flattenOptions", "(Ljava/util/List;)Ljava/util/List;", "(Lcom/discord/api/commands/ApplicationCommandValue;)Ljava/util/List;", "", "", "toStringTruncateZeroDecimal", "(Ljava/lang/Object;)Ljava/lang/String;", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetViewModelKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheetViewModel3 {
    public static final List<ApplicationCommandData3> flattenOptions(List<ApplicationCommandData3> list) {
        Intrinsics3.checkNotNullParameter(list, "$this$flattenOptions");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.addAll(flattenOptions((ApplicationCommandData3) it.next()));
        }
        return arrayList;
    }

    public static final String toStringTruncateZeroDecimal(Object obj) {
        return obj instanceof Number ? Strings4.removeSuffix(obj.toString(), ".0") : String.valueOf(obj);
    }

    public static final List<ApplicationCommandData3> flattenOptions(ApplicationCommandData3 applicationCommandData3) {
        Intrinsics3.checkNotNullParameter(applicationCommandData3, "$this$flattenOptions");
        List<ApplicationCommandData3> listC = applicationCommandData3.c();
        if (listC == null || listC.isEmpty()) {
            return CollectionsJVM.listOf(applicationCommandData3);
        }
        ArrayList arrayList = new ArrayList();
        List<ApplicationCommandData3> listC2 = applicationCommandData3.c();
        if (listC2 != null) {
            Iterator<T> it = listC2.iterator();
            while (it.hasNext()) {
                arrayList.addAll(flattenOptions((ApplicationCommandData3) it.next()));
            }
        }
        return arrayList;
    }
}

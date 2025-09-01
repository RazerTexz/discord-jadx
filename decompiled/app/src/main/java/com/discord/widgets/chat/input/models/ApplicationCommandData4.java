package com.discord.widgets.chat.input.models;

import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ApplicationCommandData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/chat/input/models/ApplicationCommandData;", "", "getCommandId", "(Lcom/discord/widgets/chat/input/models/ApplicationCommandData;)Ljava/lang/String;", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.models.ApplicationCommandDataKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class ApplicationCommandData4 {
    /* JADX WARN: Removed duplicated region for block: B:29:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String getCommandId(ApplicationCommandData applicationCommandData) {
        Object obj;
        Object next;
        ApplicationCommandValue applicationCommandValue;
        List<ApplicationCommandValue> options;
        Object next2;
        Intrinsics3.checkNotNullParameter(applicationCommandData, "$this$getCommandId");
        Iterator<T> it = applicationCommandData.getValues().iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((ApplicationCommandValue) next).getType() == 2) {
                break;
            }
        }
        ApplicationCommandValue applicationCommandValue2 = (ApplicationCommandValue) next;
        if (applicationCommandValue2 == null || (options = applicationCommandValue2.getOptions()) == null) {
            Iterator<T> it2 = applicationCommandData.getValues().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next3 = it2.next();
                if (((ApplicationCommandValue) next3).getType() == 1) {
                    obj = next3;
                    break;
                }
            }
            applicationCommandValue = (ApplicationCommandValue) obj;
        } else {
            Iterator<T> it3 = options.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it3.next();
                if (((ApplicationCommandValue) next2).getType() == 1) {
                    break;
                }
            }
            applicationCommandValue = (ApplicationCommandValue) next2;
            if (applicationCommandValue == null) {
            }
        }
        if (applicationCommandValue2 == null || applicationCommandValue == null) {
            if (applicationCommandValue == null) {
                return applicationCommandData.getApplicationCommand().getId();
            }
            return applicationCommandData.getApplicationCommand().getId() + " " + applicationCommandValue.getName();
        }
        return applicationCommandData.getApplicationCommand().getId() + " " + applicationCommandValue2.getName() + " " + applicationCommandValue.getName();
    }
}

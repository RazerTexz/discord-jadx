package com.discord.utilities.guildautomod;

import com.discord.api.message.embed.EmbedField;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: AutoModUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/utilities/guildautomod/AutoModUtils;", "", "Lcom/discord/api/message/embed/MessageEmbed;", "messageEmbed", "", ModelAuditLogEntry.CHANGE_KEY_NAME, "getEmbedFieldValue", "(Lcom/discord/api/message/embed/MessageEmbed;Ljava/lang/String;)Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class AutoModUtils {
    public static final AutoModUtils INSTANCE = new AutoModUtils();

    private AutoModUtils() {
    }

    public final String getEmbedFieldValue(MessageEmbed messageEmbed, String name) {
        Object next;
        String value;
        Intrinsics3.checkNotNullParameter(messageEmbed, "messageEmbed");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        List<EmbedField> listD = messageEmbed.d();
        if (listD != null) {
            Iterator<T> it = listD.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics3.areEqual(((EmbedField) next).getName(), name)) {
                    break;
                }
            }
            EmbedField embedField = (EmbedField) next;
            if (embedField != null && (value = embedField.getValue()) != null) {
                return value;
            }
        }
        return "";
    }
}

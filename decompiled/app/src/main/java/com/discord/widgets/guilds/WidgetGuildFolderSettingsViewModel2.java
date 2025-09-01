package com.discord.widgets.guilds;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelGuildFolder;
import com.discord.stores.StoreGuildsSorted;
import com.discord.widgets.guilds.WidgetGuildFolderSettingsViewModel;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import rx.functions.Func2;

/* compiled from: WidgetGuildFolderSettingsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\n \u0002*\u0004\u0018\u00010\u00060\u00062\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u00002\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0002*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "Lcom/discord/models/domain/ModelGuildFolder;", "kotlin.jvm.PlatformType", "guildFolders", "Lcom/discord/stores/StoreGuildsSorted$Entry;", "sortedGuilds", "Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;Ljava/util/List;)Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.WidgetGuildFolderSettingsViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildFolderSettingsViewModel2<T1, T2, R> implements Func2<List<? extends ModelGuildFolder>, List<? extends StoreGuildsSorted.Entry>, WidgetGuildFolderSettingsViewModel.StoreState> {
    public final /* synthetic */ long $folderId;

    public WidgetGuildFolderSettingsViewModel2(long j) {
        this.$folderId = j;
    }

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetGuildFolderSettingsViewModel.StoreState call(List<? extends ModelGuildFolder> list, List<? extends StoreGuildsSorted.Entry> list2) {
        return call2((List<ModelGuildFolder>) list, list2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetGuildFolderSettingsViewModel.StoreState call2(List<ModelGuildFolder> list, List<? extends StoreGuildsSorted.Entry> list2) {
        Object next;
        Intrinsics3.checkNotNullExpressionValue(list, "guildFolders");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Long id2 = ((ModelGuildFolder) next).getId();
            if (id2 != null && id2.longValue() == this.$folderId) {
                break;
            }
        }
        ModelGuildFolder modelGuildFolder = (ModelGuildFolder) next;
        if (modelGuildFolder == null) {
            return WidgetGuildFolderSettingsViewModel.StoreState.Invalid.INSTANCE;
        }
        Intrinsics3.checkNotNullExpressionValue(list2, "sortedGuilds");
        return new WidgetGuildFolderSettingsViewModel.StoreState.Valid(modelGuildFolder, list2);
    }
}

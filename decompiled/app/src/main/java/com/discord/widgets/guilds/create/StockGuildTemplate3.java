package com.discord.widgets.guilds.create;

import com.discord.restapi.RestAPIParams;
import d0.t.CollectionsJVM;
import d0.t._Collections;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

/* compiled from: StockGuildTemplate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u001aE\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\r\"\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"", "categoryName", "", "Lcom/discord/primitives/Snowflake;", "categoryId", "", "channelType", "", "Lcom/discord/widgets/guilds/create/ChannelTemplate;", "channels", "", "Lcom/discord/restapi/RestAPIParams$CreateGuildChannel;", "createCategorySection", "(Ljava/lang/String;JI[Lcom/discord/widgets/guilds/create/ChannelTemplate;)Ljava/util/List;", "SYSTEM_CHANNEL_ID", "J", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.create.StockGuildTemplateKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class StockGuildTemplate3 {
    private static final long SYSTEM_CHANNEL_ID = 11;

    public static final /* synthetic */ List access$createCategorySection(String str, long j, int i, StockGuildTemplate2... stockGuildTemplate2Arr) {
        return createCategorySection(str, j, i, stockGuildTemplate2Arr);
    }

    private static final List<RestAPIParams.CreateGuildChannel> createCategorySection(String str, long j, int i, StockGuildTemplate2... stockGuildTemplate2Arr) {
        List listListOf = CollectionsJVM.listOf(new RestAPIParams.CreateGuildChannel(4, Long.valueOf(j), str, null, null, null));
        ArrayList arrayList = new ArrayList(stockGuildTemplate2Arr.length);
        for (StockGuildTemplate2 stockGuildTemplate2 : stockGuildTemplate2Arr) {
            arrayList.add(new RestAPIParams.CreateGuildChannel(i, stockGuildTemplate2.getId(), stockGuildTemplate2.getName(), Long.valueOf(j), null, null));
        }
        return _Collections.plus((Collection) listListOf, (Iterable) arrayList);
    }
}

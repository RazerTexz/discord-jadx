package com.discord.widgets.chat.input.models;

import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import java.util.regex.Pattern;
import kotlin.Metadata;

/* compiled from: TagObject.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\f"}, d2 = {"Lcom/discord/widgets/chat/input/models/TagObject;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Ljava/util/regex/Pattern;", "getTagRegex", "()Ljava/util/regex/Pattern;", "tagRegex", "", "getDisplayTag", "()Ljava/lang/String;", "displayTag", "getTag", "tag", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public interface TagObject extends MGRecyclerDataPayload {
    String getDisplayTag();

    String getTag();

    Pattern getTagRegex();
}

package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.Model;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$LongRef;
import rx.functions.Action1;

/* compiled from: ModelReadState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "fieldName", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.models.domain.ModelReadState$Parser$parse$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ModelReadState2<T> implements Action1<String> {
    public final /* synthetic */ Ref$LongRef $channelId;
    public final /* synthetic */ Ref$LongRef $id;
    public final /* synthetic */ Ref$LongRef $lastMessageId;
    public final /* synthetic */ Ref$IntRef $mentionCount;
    public final /* synthetic */ Ref$LongRef $messageId;
    public final /* synthetic */ Model.JsonReader $reader;
    public final /* synthetic */ Ref$IntRef $version;

    public ModelReadState2(Ref$LongRef ref$LongRef, Model.JsonReader jsonReader, Ref$IntRef ref$IntRef, Ref$LongRef ref$LongRef2, Ref$LongRef ref$LongRef3, Ref$LongRef ref$LongRef4, Ref$IntRef ref$IntRef2) {
        this.$id = ref$LongRef;
        this.$reader = jsonReader;
        this.$mentionCount = ref$IntRef;
        this.$lastMessageId = ref$LongRef2;
        this.$messageId = ref$LongRef3;
        this.$channelId = ref$LongRef4;
        this.$version = ref$IntRef2;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str != null) {
            switch (str.hashCode()) {
                case -1930808873:
                    if (str.equals(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID)) {
                        Ref$LongRef ref$LongRef = this.$channelId;
                        ref$LongRef.element = this.$reader.nextLong(ref$LongRef.element);
                        return;
                    }
                    break;
                case -1690722221:
                    if (str.equals("message_id")) {
                        Ref$LongRef ref$LongRef2 = this.$messageId;
                        ref$LongRef2.element = this.$reader.nextLong(ref$LongRef2.element);
                        return;
                    }
                    break;
                case -83031652:
                    if (str.equals("last_message_id")) {
                        Ref$LongRef ref$LongRef3 = this.$lastMessageId;
                        ref$LongRef3.element = this.$reader.nextLong(ref$LongRef3.element);
                        return;
                    }
                    break;
                case 3355:
                    if (str.equals(ModelAuditLogEntry.CHANGE_KEY_ID)) {
                        this.$id.element = this.$reader.nextLong(0L);
                        return;
                    }
                    break;
                case 351608024:
                    if (str.equals("version")) {
                        Ref$IntRef ref$IntRef = this.$version;
                        ref$IntRef.element = this.$reader.nextInt(ref$IntRef.element);
                        return;
                    }
                    break;
                case 2144418426:
                    if (str.equals("mention_count")) {
                        Ref$IntRef ref$IntRef2 = this.$mentionCount;
                        ref$IntRef2.element = this.$reader.nextInt(ref$IntRef2.element);
                        return;
                    }
                    break;
            }
        }
        this.$reader.skipValue();
    }
}

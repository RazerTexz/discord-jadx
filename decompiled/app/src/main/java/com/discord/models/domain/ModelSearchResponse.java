package com.discord.models.domain;

import androidx.core.app.FrameMetricsAggregator;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.message.Message;
import com.discord.api.thread.ThreadMember;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ModelSearchResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b;\u0010<J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\t\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\f\u0010\nJ\u0018\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u000e\u0010\nJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0092\u0001\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00022\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u00072\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00072\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00072\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b \u0010\u0011J\u0010\u0010!\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b!\u0010\u0006J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u0019\u0010'\u001a\u00020&8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010+\u001a\u0004\b,\u0010\u0004R'\u0010\u0016\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010-\u001a\u0004\b.\u0010\nR\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010/\u001a\u0004\b0\u0010\u0011R!\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010-\u001a\u0004\b1\u0010\nR!\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010-\u001a\u0004\b2\u0010\nR#\u00106\u001a\b\u0012\u0004\u0012\u00020\b0\u00078F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u0010\nR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010+\u001a\u0004\b7\u0010\u0004R\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u00108\u001a\u0004\b9\u0010\u0006R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010/\u001a\u0004\b:\u0010\u0011R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010+¨\u0006="}, d2 = {"Lcom/discord/models/domain/ModelSearchResponse;", "", "", "component9", "()Ljava/lang/Integer;", "component1", "()I", "", "Lcom/discord/api/message/Message;", "component2", "()Ljava/util/List;", "Lcom/discord/api/channel/Channel;", "component3", "Lcom/discord/api/thread/ThreadMember;", "component4", "", "component5", "()Ljava/lang/String;", "component6", "component7", "component8", "totalResults", "messages", "threads", "members", "analyticsId", "message", "errorCode", "documentIndexed", "retryAfter", "copy", "(ILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/discord/models/domain/ModelSearchResponse;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "retryMillis", "J", "getRetryMillis", "()J", "Ljava/lang/Integer;", "getErrorCode", "Ljava/util/List;", "getMessages", "Ljava/lang/String;", "getMessage", "getThreads", "getMembers", "hits$delegate", "Lkotlin/Lazy;", "getHits", "hits", "getDocumentIndexed", "I", "getTotalResults", "getAnalyticsId", "<init>", "(ILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelSearchResponse {
    private final String analyticsId;
    private final Integer documentIndexed;
    private final Integer errorCode;

    /* renamed from: hits$delegate, reason: from kotlin metadata */
    private final Lazy hits;
    private final List<ThreadMember> members;
    private final String message;
    private final List<List<Message>> messages;
    private final Integer retryAfter;
    private final long retryMillis;
    private final List<Channel> threads;
    private final int totalResults;

    public ModelSearchResponse() {
        this(0, null, null, null, null, null, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ModelSearchResponse(int i, List<? extends List<Message>> list, List<Channel> list2, List<? extends ThreadMember> list3, String str, String str2, Integer num, Integer num2, Integer num3) {
        this.totalResults = i;
        this.messages = list;
        this.threads = list2;
        this.members = list3;
        this.analyticsId = str;
        this.message = str2;
        this.errorCode = num;
        this.documentIndexed = num2;
        this.retryAfter = num3;
        this.retryMillis = (num3 != null ? num3.intValue() : 0L) * 1000;
        this.hits = LazyJVM.lazy(new ModelSearchResponse2(this));
    }

    /* renamed from: component9, reason: from getter */
    private final Integer getRetryAfter() {
        return this.retryAfter;
    }

    public static /* synthetic */ ModelSearchResponse copy$default(ModelSearchResponse modelSearchResponse, int i, List list, List list2, List list3, String str, String str2, Integer num, Integer num2, Integer num3, int i2, Object obj) {
        return modelSearchResponse.copy((i2 & 1) != 0 ? modelSearchResponse.totalResults : i, (i2 & 2) != 0 ? modelSearchResponse.messages : list, (i2 & 4) != 0 ? modelSearchResponse.threads : list2, (i2 & 8) != 0 ? modelSearchResponse.members : list3, (i2 & 16) != 0 ? modelSearchResponse.analyticsId : str, (i2 & 32) != 0 ? modelSearchResponse.message : str2, (i2 & 64) != 0 ? modelSearchResponse.errorCode : num, (i2 & 128) != 0 ? modelSearchResponse.documentIndexed : num2, (i2 & 256) != 0 ? modelSearchResponse.retryAfter : num3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getTotalResults() {
        return this.totalResults;
    }

    public final List<List<Message>> component2() {
        return this.messages;
    }

    public final List<Channel> component3() {
        return this.threads;
    }

    public final List<ThreadMember> component4() {
        return this.members;
    }

    /* renamed from: component5, reason: from getter */
    public final String getAnalyticsId() {
        return this.analyticsId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component7, reason: from getter */
    public final Integer getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component8, reason: from getter */
    public final Integer getDocumentIndexed() {
        return this.documentIndexed;
    }

    public final ModelSearchResponse copy(int totalResults, List<? extends List<Message>> messages, List<Channel> threads, List<? extends ThreadMember> members, String analyticsId, String message, Integer errorCode, Integer documentIndexed, Integer retryAfter) {
        return new ModelSearchResponse(totalResults, messages, threads, members, analyticsId, message, errorCode, documentIndexed, retryAfter);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelSearchResponse)) {
            return false;
        }
        ModelSearchResponse modelSearchResponse = (ModelSearchResponse) other;
        return this.totalResults == modelSearchResponse.totalResults && Intrinsics3.areEqual(this.messages, modelSearchResponse.messages) && Intrinsics3.areEqual(this.threads, modelSearchResponse.threads) && Intrinsics3.areEqual(this.members, modelSearchResponse.members) && Intrinsics3.areEqual(this.analyticsId, modelSearchResponse.analyticsId) && Intrinsics3.areEqual(this.message, modelSearchResponse.message) && Intrinsics3.areEqual(this.errorCode, modelSearchResponse.errorCode) && Intrinsics3.areEqual(this.documentIndexed, modelSearchResponse.documentIndexed) && Intrinsics3.areEqual(this.retryAfter, modelSearchResponse.retryAfter);
    }

    public final String getAnalyticsId() {
        return this.analyticsId;
    }

    public final Integer getDocumentIndexed() {
        return this.documentIndexed;
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final List<Message> getHits() {
        return (List) this.hits.getValue();
    }

    public final List<ThreadMember> getMembers() {
        return this.members;
    }

    public final String getMessage() {
        return this.message;
    }

    public final List<List<Message>> getMessages() {
        return this.messages;
    }

    public final long getRetryMillis() {
        return this.retryMillis;
    }

    public final List<Channel> getThreads() {
        return this.threads;
    }

    public final int getTotalResults() {
        return this.totalResults;
    }

    public int hashCode() {
        int i = this.totalResults * 31;
        List<List<Message>> list = this.messages;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        List<Channel> list2 = this.threads;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<ThreadMember> list3 = this.members;
        int iHashCode3 = (iHashCode2 + (list3 != null ? list3.hashCode() : 0)) * 31;
        String str = this.analyticsId;
        int iHashCode4 = (iHashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.message;
        int iHashCode5 = (iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.errorCode;
        int iHashCode6 = (iHashCode5 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.documentIndexed;
        int iHashCode7 = (iHashCode6 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.retryAfter;
        return iHashCode7 + (num3 != null ? num3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelSearchResponse(totalResults=");
        sbU.append(this.totalResults);
        sbU.append(", messages=");
        sbU.append(this.messages);
        sbU.append(", threads=");
        sbU.append(this.threads);
        sbU.append(", members=");
        sbU.append(this.members);
        sbU.append(", analyticsId=");
        sbU.append(this.analyticsId);
        sbU.append(", message=");
        sbU.append(this.message);
        sbU.append(", errorCode=");
        sbU.append(this.errorCode);
        sbU.append(", documentIndexed=");
        sbU.append(this.documentIndexed);
        sbU.append(", retryAfter=");
        return outline.F(sbU, this.retryAfter, ")");
    }

    public /* synthetic */ ModelSearchResponse(int i, List list, List list2, List list3, String str, String str2, Integer num, Integer num2, Integer num3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : list, (i2 & 4) != 0 ? null : list2, (i2 & 8) != 0 ? null : list3, (i2 & 16) != 0 ? null : str, (i2 & 32) != 0 ? null : str2, (i2 & 64) != 0 ? null : num, (i2 & 128) != 0 ? null : num2, (i2 & 256) == 0 ? num3 : null);
    }
}

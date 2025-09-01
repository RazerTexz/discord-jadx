package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreMessageUploads;
import com.discord.utilities.rest.SendUtils;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress;
import d0.t._Collections;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import rx.Observable;

/* compiled from: WidgetChatListAdapterItemUploadProgress.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/stores/StoreMessageUploads$MessageUploadState;", "kotlin.jvm.PlatformType", "messageUploadState", "Lrx/Observable;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreMessageUploads$MessageUploadState;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemUploadProgress$ModelProvider$get$2<T, R> implements Func1<StoreMessageUploads.MessageUploadState, Observable<? extends WidgetChatListAdapterItemUploadProgress.Model>> {
    public final /* synthetic */ long $throttleIntervalMs;

    public WidgetChatListAdapterItemUploadProgress$ModelProvider$get$2(long j) {
        this.$throttleIntervalMs = j;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListAdapterItemUploadProgress.Model> call(StoreMessageUploads.MessageUploadState messageUploadState) {
        return call2(messageUploadState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChatListAdapterItemUploadProgress.Model> call2(StoreMessageUploads.MessageUploadState messageUploadState) {
        if (messageUploadState instanceof StoreMessageUploads.MessageUploadState.None) {
            return new ScalarSynchronousObservable(WidgetChatListAdapterItemUploadProgress.Model.None.INSTANCE);
        }
        if (messageUploadState instanceof StoreMessageUploads.MessageUploadState.Preprocessing) {
            StoreMessageUploads.MessageUploadState.Preprocessing preprocessing = (StoreMessageUploads.MessageUploadState.Preprocessing) messageUploadState;
            return new ScalarSynchronousObservable(new WidgetChatListAdapterItemUploadProgress.Model.Preprocessing(preprocessing.getNumFiles(), preprocessing.getDisplayName(), preprocessing.getMimeType()));
        }
        if (!(messageUploadState instanceof StoreMessageUploads.MessageUploadState.Uploading)) {
            throw new NoWhenBranchMatchedException();
        }
        List<SendUtils.FileUpload> uploads = ((StoreMessageUploads.MessageUploadState.Uploading) messageUploadState).getUploads();
        return uploads.size() == 1 ? WidgetChatListAdapterItemUploadProgress.ModelProvider.access$getSingleUploadObservable(WidgetChatListAdapterItemUploadProgress.ModelProvider.INSTANCE, (SendUtils.FileUpload) _Collections.first((List) uploads), this.$throttleIntervalMs) : uploads.size() <= 3 ? WidgetChatListAdapterItemUploadProgress.ModelProvider.access$getFewUploadsObservable(WidgetChatListAdapterItemUploadProgress.ModelProvider.INSTANCE, uploads, this.$throttleIntervalMs) : WidgetChatListAdapterItemUploadProgress.ModelProvider.access$getManyUploadsObservable(WidgetChatListAdapterItemUploadProgress.ModelProvider.INSTANCE, uploads, this.$throttleIntervalMs);
    }
}

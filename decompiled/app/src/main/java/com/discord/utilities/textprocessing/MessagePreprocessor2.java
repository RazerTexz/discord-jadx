package com.discord.utilities.textprocessing;

import b.a.t.b.c.NodeProcessor;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.textprocessing.node.Spoilerable;
import kotlin.Metadata;

/* compiled from: MessagePreprocessor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0001 \u0002*\b\u0012\u0002\b\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/simpleast/core/node/Node;", "", "kotlin.jvm.PlatformType", "node", "", "processNode", "(Lcom/discord/simpleast/core/node/Node;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.textprocessing.MessagePreprocessor$processSpoilerChildren$3$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class MessagePreprocessor2 implements NodeProcessor {
    public static final MessagePreprocessor2 INSTANCE = new MessagePreprocessor2();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.a.t.b.c.NodeProcessor
    public final void processNode(Node<Object> node) {
        if (node instanceof Spoilerable) {
            ((Spoilerable) node).setRevealed(false);
        }
    }
}

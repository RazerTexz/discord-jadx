package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.api.application.Application;
import com.discord.api.premium.PremiumTier;
import com.discord.models.domain.Model;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: ModelSku.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001:\u0006FGHIJKBs\u0012\n\u0010\u001e\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0006\u0012\n\u0010 \u001a\u00060\u0002j\u0002`\t\u0012\b\u0010!\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\"\u001a\u00020\u000e\u0012\u0006\u0010#\u001a\u00020\u0011\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010%\u001a\u00020\u0011\u0012\u001e\u0010&\u001a\u001a\u0012\b\u0012\u00060\u0011j\u0002`\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0018j\u0004\u0018\u0001`\u001b¢\u0006\u0004\bD\u0010EJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\n\u001a\u00060\u0002j\u0002`\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u0005J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0013J(\u0010\u001c\u001a\u001a\u0012\b\u0012\u00060\u0011j\u0002`\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0018j\u0004\u0018\u0001`\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u008e\u0001\u0010'\u001a\u00020\u00002\f\b\u0002\u0010\u001e\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00062\f\b\u0002\u0010 \u001a\u00060\u0002j\u0002`\t2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020\u00112\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010%\u001a\u00020\u00112 \b\u0002\u0010&\u001a\u001a\u0012\b\u0012\u00060\u0011j\u0002`\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0018j\u0004\u0018\u0001`\u001bHÆ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b)\u0010\bJ\u0010\u0010*\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b*\u0010\u0013J\u001a\u0010,\u001a\u00020\u000e2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b,\u0010-R\u0013\u0010.\u001a\u00020\u000e8F@\u0006¢\u0006\u0006\u001a\u0004\b.\u0010\u0010R\u0013\u0010/\u001a\u00020\u000e8F@\u0006¢\u0006\u0006\u001a\u0004\b/\u0010\u0010R\u0019\u0010\u001f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00100\u001a\u0004\b1\u0010\bR\u001d\u0010 \u001a\u00060\u0002j\u0002`\t8\u0006@\u0006¢\u0006\f\n\u0004\b \u00102\u001a\u0004\b3\u0010\u0005R\u0019\u0010#\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b#\u00104\u001a\u0004\b5\u0010\u0013R\u001d\u0010\u001e\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00102\u001a\u0004\b6\u0010\u0005R\u001b\u0010$\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b$\u00107\u001a\u0004\b8\u0010\u0016R\u0019\u0010\"\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00109\u001a\u0004\b:\u0010\u0010R\u0019\u0010%\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b%\u00104\u001a\u0004\b;\u0010\u0013R\u001b\u0010!\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010<\u001a\u0004\b=\u0010\rR1\u0010&\u001a\u001a\u0012\b\u0012\u00060\u0011j\u0002`\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0018j\u0004\u0018\u0001`\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010>\u001a\u0004\b?\u0010\u001dR\u0013\u0010C\u001a\u00020@8F@\u0006¢\u0006\u0006\u001a\u0004\bA\u0010B¨\u0006L"}, d2 = {"Lcom/discord/models/domain/ModelSku;", "", "", "Lcom/discord/primitives/ApplicationId;", "component1", "()J", "", "component2", "()Ljava/lang/String;", "Lcom/discord/primitives/SkuId;", "component3", "Lcom/discord/api/application/Application;", "component4", "()Lcom/discord/api/application/Application;", "", "component5", "()Z", "", "component6", "()I", "Lcom/discord/models/domain/ModelSku$Price;", "component7", "()Lcom/discord/models/domain/ModelSku$Price;", "component8", "", "Lcom/discord/primitives/PaymentGatewayId;", "Lcom/discord/models/domain/ModelSku$ExternalSkuStrategy;", "Lcom/discord/models/domain/ExternalSkuStrategies;", "component9", "()Ljava/util/Map;", "applicationId", ModelAuditLogEntry.CHANGE_KEY_NAME, ModelAuditLogEntry.CHANGE_KEY_ID, "application", "premium", "type", "price", "flags", "externalSkuStrategies", "copy", "(JLjava/lang/String;JLcom/discord/api/application/Application;ZILcom/discord/models/domain/ModelSku$Price;ILjava/util/Map;)Lcom/discord/models/domain/ModelSku;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "isStickerPack", "isAvailable", "Ljava/lang/String;", "getName", "J", "getId", "I", "getType", "getApplicationId", "Lcom/discord/models/domain/ModelSku$Price;", "getPrice", "Z", "getPremium", "getFlags", "Lcom/discord/api/application/Application;", "getApplication", "Ljava/util/Map;", "getExternalSkuStrategies", "Lcom/discord/models/domain/ModelSku$SkuCategory;", "getSkuCategory", "()Lcom/discord/models/domain/ModelSku$SkuCategory;", "skuCategory", "<init>", "(JLjava/lang/String;JLcom/discord/api/application/Application;ZILcom/discord/models/domain/ModelSku$Price;ILjava/util/Map;)V", "ExternalSkuStrategy", "ExternalStrategyTypes", "ModelPremiumSkuPrice", "Parser", "Price", "SkuCategory", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelSku {
    private final Application application;
    private final long applicationId;
    private final Map<Integer, ExternalSkuStrategy> externalSkuStrategies;
    private final int flags;
    private final long id;
    private final String name;
    private final boolean premium;
    private final Price price;
    private final int type;

    /* compiled from: ModelSku.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0007J\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0003\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/discord/models/domain/ModelSku$ExternalSkuStrategy;", "", "Lcom/discord/models/domain/ModelSku$ExternalStrategyTypes;", "getType", "()Lcom/discord/models/domain/ModelSku$ExternalStrategyTypes;", "", "component1", "()I", "type", "copy", "(I)Lcom/discord/models/domain/ModelSku$ExternalSkuStrategy;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "<init>", "(I)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ExternalSkuStrategy {
        private final int type;

        public ExternalSkuStrategy(int i) {
            this.type = i;
        }

        public static /* synthetic */ ExternalSkuStrategy copy$default(ExternalSkuStrategy externalSkuStrategy, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = externalSkuStrategy.type;
            }
            return externalSkuStrategy.copy(i);
        }

        /* renamed from: component1, reason: from getter */
        public final int getType() {
            return this.type;
        }

        public final ExternalSkuStrategy copy(int type) {
            return new ExternalSkuStrategy(type);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof ExternalSkuStrategy) && this.type == ((ExternalSkuStrategy) other).type;
            }
            return true;
        }

        public final int getType() {
            return this.type;
        }

        public int hashCode() {
            return this.type;
        }

        public String toString() {
            return outline.B(outline.U("ExternalSkuStrategy(type="), this.type, ")");
        }

        /* renamed from: getType, reason: collision with other method in class */
        public final ExternalStrategyTypes m6getType() {
            return ExternalStrategyTypes.INSTANCE.from(this.type);
        }
    }

    /* compiled from: ModelSku.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0013\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/discord/models/domain/ModelSku$ExternalStrategyTypes;", "", "", "intRepresentation", "Ljava/lang/Integer;", "getIntRepresentation", "()Ljava/lang/Integer;", "<init>", "(Ljava/lang/String;ILjava/lang/Integer;)V", "Companion", "CONSTANT", "APPLE", "GOOGLE", "UNKNOWN", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public enum ExternalStrategyTypes {
        CONSTANT(1),
        APPLE(2),
        GOOGLE(3),
        UNKNOWN(null);


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Integer intRepresentation;

        /* compiled from: ModelSku.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/models/domain/ModelSku$ExternalStrategyTypes$Companion;", "", "", "externalStrategyInt", "Lcom/discord/models/domain/ModelSku$ExternalStrategyTypes;", "from", "(I)Lcom/discord/models/domain/ModelSku$ExternalStrategyTypes;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final ExternalStrategyTypes from(int externalStrategyInt) {
                ExternalStrategyTypes externalStrategyTypes;
                ExternalStrategyTypes[] externalStrategyTypesArrValues = ExternalStrategyTypes.values();
                int i = 0;
                while (true) {
                    if (i >= 4) {
                        externalStrategyTypes = null;
                        break;
                    }
                    externalStrategyTypes = externalStrategyTypesArrValues[i];
                    Integer intRepresentation = externalStrategyTypes.getIntRepresentation();
                    if (intRepresentation != null && intRepresentation.intValue() == externalStrategyInt) {
                        break;
                    }
                    i++;
                }
                return externalStrategyTypes != null ? externalStrategyTypes : ExternalStrategyTypes.UNKNOWN;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        ExternalStrategyTypes(Integer num) {
            this.intRepresentation = num;
        }

        public final Integer getIntRepresentation() {
            return this.intRepresentation;
        }
    }

    /* compiled from: ModelSku.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/models/domain/ModelSku$ModelPremiumSkuPrice;", "", "", "component1", "()I", "component2", "amount", "percentage", "copy", "(II)Lcom/discord/models/domain/ModelSku$ModelPremiumSkuPrice;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getPercentage", "getAmount", "<init>", "(II)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ModelPremiumSkuPrice {
        private final int amount;
        private final int percentage;

        public ModelPremiumSkuPrice(int i, int i2) {
            this.amount = i;
            this.percentage = i2;
        }

        public static /* synthetic */ ModelPremiumSkuPrice copy$default(ModelPremiumSkuPrice modelPremiumSkuPrice, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = modelPremiumSkuPrice.amount;
            }
            if ((i3 & 2) != 0) {
                i2 = modelPremiumSkuPrice.percentage;
            }
            return modelPremiumSkuPrice.copy(i, i2);
        }

        /* renamed from: component1, reason: from getter */
        public final int getAmount() {
            return this.amount;
        }

        /* renamed from: component2, reason: from getter */
        public final int getPercentage() {
            return this.percentage;
        }

        public final ModelPremiumSkuPrice copy(int amount, int percentage) {
            return new ModelPremiumSkuPrice(amount, percentage);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ModelPremiumSkuPrice)) {
                return false;
            }
            ModelPremiumSkuPrice modelPremiumSkuPrice = (ModelPremiumSkuPrice) other;
            return this.amount == modelPremiumSkuPrice.amount && this.percentage == modelPremiumSkuPrice.percentage;
        }

        public final int getAmount() {
            return this.amount;
        }

        public final int getPercentage() {
            return this.percentage;
        }

        public int hashCode() {
            return (this.amount * 31) + this.percentage;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ModelPremiumSkuPrice(amount=");
            sbU.append(this.amount);
            sbU.append(", percentage=");
            return outline.B(sbU, this.percentage, ")");
        }
    }

    /* compiled from: ModelSku.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/models/domain/ModelSku$Parser;", "Lcom/discord/models/domain/Model$Parser;", "Lcom/discord/models/domain/ModelSku;", "Lcom/discord/models/domain/Model$JsonReader;", "reader", "parse", "(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/domain/ModelSku;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Parser implements Model.Parser<ModelSku> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        @Override // com.discord.models.domain.Model.Parser
        public /* bridge */ /* synthetic */ ModelSku parse(Model.JsonReader jsonReader) {
            return parse(jsonReader);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.discord.models.domain.Model.Parser
        public ModelSku parse(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRefC0 = outline.c0(reader, "reader");
            ref$ObjectRefC0.element = null;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
            ref$ObjectRef3.element = null;
            Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
            ref$ObjectRef4.element = null;
            Ref$ObjectRef ref$ObjectRef5 = new Ref$ObjectRef();
            ref$ObjectRef5.element = null;
            Ref$ObjectRef ref$ObjectRef6 = new Ref$ObjectRef();
            ref$ObjectRef6.element = null;
            Ref$ObjectRef ref$ObjectRef7 = new Ref$ObjectRef();
            ref$ObjectRef7.element = null;
            reader.nextObject(new ModelSku2(ref$ObjectRefC0, reader, ref$ObjectRef, ref$ObjectRef2, ref$ObjectRef3, ref$ObjectRef4, ref$ObjectRef5, ref$ObjectRef6, ref$ObjectRef7));
            Long l = (Long) ref$ObjectRefC0.element;
            long jLongValue = l != null ? l.longValue() : 0L;
            String str = (String) ref$ObjectRef.element;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            Long l2 = (Long) ref$ObjectRef2.element;
            long jLongValue2 = l2 != null ? l2.longValue() : 0L;
            Application application = (Application) ref$ObjectRef3.element;
            Boolean bool = (Boolean) ref$ObjectRef4.element;
            Intrinsics3.checkNotNull(bool);
            boolean zBooleanValue = bool.booleanValue();
            Integer num = (Integer) ref$ObjectRef5.element;
            Intrinsics3.checkNotNull(num);
            int iIntValue = num.intValue();
            Price price = (Price) ref$ObjectRef6.element;
            Integer num2 = (Integer) ref$ObjectRef7.element;
            Intrinsics3.checkNotNull(num2);
            return new ModelSku(jLongValue, str2, jLongValue2, application, zBooleanValue, iIntValue, price, num2.intValue(), null);
        }
    }

    /* compiled from: ModelSku.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001:\u0001 B/\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ<\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R'\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0018\u001a\u0004\b\u0019\u0010\fR\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004¨\u0006!"}, d2 = {"Lcom/discord/models/domain/ModelSku$Price;", "", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "", "Lcom/discord/api/premium/PremiumTier;", "Lcom/discord/models/domain/ModelSku$ModelPremiumSkuPrice;", "component3", "()Ljava/util/Map;", "amount", "currency", "premium", "copy", "(ILjava/lang/String;Ljava/util/Map;)Lcom/discord/models/domain/ModelSku$Price;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getPremium", "Ljava/lang/String;", "getCurrency", "I", "getAmount", "<init>", "(ILjava/lang/String;Ljava/util/Map;)V", "Parser", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Price {
        private final int amount;
        private final String currency;
        private final Map<PremiumTier, ModelPremiumSkuPrice> premium;

        /* compiled from: ModelSku.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/models/domain/ModelSku$Price$Parser;", "Lcom/discord/models/domain/Model$Parser;", "Lcom/discord/models/domain/ModelSku$Price;", "Lcom/discord/models/domain/Model$JsonReader;", "reader", "parse", "(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/domain/ModelSku$Price;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Parser implements Model.Parser<Price> {
            public static final Parser INSTANCE = new Parser();

            private Parser() {
            }

            @Override // com.discord.models.domain.Model.Parser
            public /* bridge */ /* synthetic */ Price parse(Model.JsonReader jsonReader) {
                return parse(jsonReader);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.discord.models.domain.Model.Parser
            public Price parse(Model.JsonReader reader) throws IOException {
                Ref$ObjectRef ref$ObjectRefC0 = outline.c0(reader, "reader");
                ref$ObjectRefC0.element = null;
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ref$ObjectRef.element = null;
                reader.nextObject(new ModelSku3(ref$ObjectRefC0, reader, ref$ObjectRef));
                Integer num = (Integer) ref$ObjectRefC0.element;
                int iIntValue = num != null ? num.intValue() : -1;
                String str = (String) ref$ObjectRef.element;
                if (str == null) {
                    str = "";
                }
                return new Price(iIntValue, str, null, 4, null);
            }
        }

        public Price(int i, String str, Map<PremiumTier, ModelPremiumSkuPrice> map) {
            Intrinsics3.checkNotNullParameter(str, "currency");
            this.amount = i;
            this.currency = str;
            this.premium = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Price copy$default(Price price, int i, String str, Map map, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = price.amount;
            }
            if ((i2 & 2) != 0) {
                str = price.currency;
            }
            if ((i2 & 4) != 0) {
                map = price.premium;
            }
            return price.copy(i, str, map);
        }

        /* renamed from: component1, reason: from getter */
        public final int getAmount() {
            return this.amount;
        }

        /* renamed from: component2, reason: from getter */
        public final String getCurrency() {
            return this.currency;
        }

        public final Map<PremiumTier, ModelPremiumSkuPrice> component3() {
            return this.premium;
        }

        public final Price copy(int amount, String currency, Map<PremiumTier, ModelPremiumSkuPrice> premium) {
            Intrinsics3.checkNotNullParameter(currency, "currency");
            return new Price(amount, currency, premium);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Price)) {
                return false;
            }
            Price price = (Price) other;
            return this.amount == price.amount && Intrinsics3.areEqual(this.currency, price.currency) && Intrinsics3.areEqual(this.premium, price.premium);
        }

        public final int getAmount() {
            return this.amount;
        }

        public final String getCurrency() {
            return this.currency;
        }

        public final Map<PremiumTier, ModelPremiumSkuPrice> getPremium() {
            return this.premium;
        }

        public int hashCode() {
            int i = this.amount * 31;
            String str = this.currency;
            int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            Map<PremiumTier, ModelPremiumSkuPrice> map = this.premium;
            return iHashCode + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Price(amount=");
            sbU.append(this.amount);
            sbU.append(", currency=");
            sbU.append(this.currency);
            sbU.append(", premium=");
            return outline.M(sbU, this.premium, ")");
        }

        public /* synthetic */ Price(int i, String str, Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, str, (i2 & 4) != 0 ? null : map);
        }
    }

    /* compiled from: ModelSku.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/models/domain/ModelSku$SkuCategory;", "", "<init>", "(Ljava/lang/String;I)V", "GAME", "NITRO", "NITRO_CLASSIC", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public enum SkuCategory {
        GAME,
        NITRO,
        NITRO_CLASSIC
    }

    public ModelSku(long j, String str, long j2, Application application, boolean z2, int i, Price price, int i2, Map<Integer, ExternalSkuStrategy> map) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.applicationId = j;
        this.name = str;
        this.id = j2;
        this.application = application;
        this.premium = z2;
        this.type = i;
        this.price = price;
        this.flags = i2;
        this.externalSkuStrategies = map;
    }

    public static /* synthetic */ ModelSku copy$default(ModelSku modelSku, long j, String str, long j2, Application application, boolean z2, int i, Price price, int i2, Map map, int i3, Object obj) {
        return modelSku.copy((i3 & 1) != 0 ? modelSku.applicationId : j, (i3 & 2) != 0 ? modelSku.name : str, (i3 & 4) != 0 ? modelSku.id : j2, (i3 & 8) != 0 ? modelSku.application : application, (i3 & 16) != 0 ? modelSku.premium : z2, (i3 & 32) != 0 ? modelSku.type : i, (i3 & 64) != 0 ? modelSku.price : price, (i3 & 128) != 0 ? modelSku.flags : i2, (i3 & 256) != 0 ? modelSku.externalSkuStrategies : map);
    }

    /* renamed from: component1, reason: from getter */
    public final long getApplicationId() {
        return this.applicationId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component4, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getPremium() {
        return this.premium;
    }

    /* renamed from: component6, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: component7, reason: from getter */
    public final Price getPrice() {
        return this.price;
    }

    /* renamed from: component8, reason: from getter */
    public final int getFlags() {
        return this.flags;
    }

    public final Map<Integer, ExternalSkuStrategy> component9() {
        return this.externalSkuStrategies;
    }

    public final ModelSku copy(long applicationId, String name, long id2, Application application, boolean premium, int type, Price price, int flags, Map<Integer, ExternalSkuStrategy> externalSkuStrategies) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new ModelSku(applicationId, name, id2, application, premium, type, price, flags, externalSkuStrategies);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelSku)) {
            return false;
        }
        ModelSku modelSku = (ModelSku) other;
        return this.applicationId == modelSku.applicationId && Intrinsics3.areEqual(this.name, modelSku.name) && this.id == modelSku.id && Intrinsics3.areEqual(this.application, modelSku.application) && this.premium == modelSku.premium && this.type == modelSku.type && Intrinsics3.areEqual(this.price, modelSku.price) && this.flags == modelSku.flags && Intrinsics3.areEqual(this.externalSkuStrategies, modelSku.externalSkuStrategies);
    }

    public final Application getApplication() {
        return this.application;
    }

    public final long getApplicationId() {
        return this.applicationId;
    }

    public final Map<Integer, ExternalSkuStrategy> getExternalSkuStrategies() {
        return this.externalSkuStrategies;
    }

    public final int getFlags() {
        return this.flags;
    }

    public final long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getPremium() {
        return this.premium;
    }

    public final Price getPrice() {
        return this.price;
    }

    public final SkuCategory getSkuCategory() {
        long j = this.id;
        return j == ModelSku4.PREMIUM_TIER_1_SKU_ID ? SkuCategory.NITRO_CLASSIC : j == ModelSku4.PREMIUM_TIER_2_SKU_ID ? SkuCategory.NITRO : SkuCategory.GAME;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        long j = this.applicationId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.name;
        int iHashCode = str != null ? str.hashCode() : 0;
        long j2 = this.id;
        int i2 = (((i + iHashCode) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        Application application = this.application;
        int iHashCode2 = (i2 + (application != null ? application.hashCode() : 0)) * 31;
        boolean z2 = this.premium;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int i4 = (((iHashCode2 + i3) * 31) + this.type) * 31;
        Price price = this.price;
        int iHashCode3 = (((i4 + (price != null ? price.hashCode() : 0)) * 31) + this.flags) * 31;
        Map<Integer, ExternalSkuStrategy> map = this.externalSkuStrategies;
        return iHashCode3 + (map != null ? map.hashCode() : 0);
    }

    public final boolean isAvailable() {
        return (this.flags & 4) > 0;
    }

    public final boolean isStickerPack() {
        return (this.flags & 16) > 0;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelSku(applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", id=");
        sbU.append(this.id);
        sbU.append(", application=");
        sbU.append(this.application);
        sbU.append(", premium=");
        sbU.append(this.premium);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", price=");
        sbU.append(this.price);
        sbU.append(", flags=");
        sbU.append(this.flags);
        sbU.append(", externalSkuStrategies=");
        return outline.M(sbU, this.externalSkuStrategies, ")");
    }
}

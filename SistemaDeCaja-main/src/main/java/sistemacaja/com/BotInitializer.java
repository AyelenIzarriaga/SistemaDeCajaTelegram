package sistemacaja.com;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import jakarta.annotation.PostConstruct;

@Configuration
public class BotInitializer {

    private final CajaBot cajaBot;

    public BotInitializer(CajaBot cajaBot) {
        this.cajaBot = cajaBot;
    }

    @PostConstruct
    public void init() {
        int intentos = 5;
        int esperaMs = 5000; // 5 segundos entre reintentos

        for (int i = 1; i <= intentos; i++) {
            try {
                cajaBot.clearWebhook();
                TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
                api.registerBot(cajaBot);
                System.out.println("🤖 Bot registrado correctamente en intento " + i);
                return; // salió bien, terminar
            } catch (Exception e) {
                System.out.println("⚠️ Intento " + i + " fallido: " + e.getMessage());
                if (i < intentos) {
                    try {
                        Thread.sleep(esperaMs);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                    }
                } else {
                    System.out.println("❌ No se pudo iniciar el bot tras " + intentos + " intentos.");
                    e.printStackTrace();
                }
            }
        }
    }
}


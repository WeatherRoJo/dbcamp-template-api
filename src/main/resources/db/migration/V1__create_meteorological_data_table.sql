CREATE TABLE IF NOT EXISTS meteorological_data (
  id BIGSERIAL NOT NULL,
  city VARCHAR(45) NOT NULL,
  weather_date DATE NOT NULL,
  morning_weather VARCHAR(20) NOT NULL,
  night_weather VARCHAR(20) NOT NULL,
  max_temperature INTEGER NOT NULL,
  min_temperature INTEGER NOT NULL,
  humidity INTEGER NOT NULL,
  precipitation INTEGER NOT NULL,
  wind_speed INTEGER NOT NULL,
  PRIMARY KEY (id)
);